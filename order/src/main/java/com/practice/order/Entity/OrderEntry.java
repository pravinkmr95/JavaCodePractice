package com.practice.order.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "orders", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"order_id", "details"}),
        @UniqueConstraint(columnNames = {"order_details"}),
        @UniqueConstraint(columnNames = {"order_details", "numberOfItems"})
})
@Data
@NoArgsConstructor
public class OrderEntry {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;
    @Column(name = "order_details", unique = true, nullable = false, length = 100)
    private String details;

    @Column(nullable = false)
    private int numberOfItems;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @NonNull
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    //@JsonBackReference
    private Customer customer;
//    public OrderEntry() {}
//
//    public OrderEntry(Long orderId, String orderDetails, Customer customer) {
//        this.order_id = orderId;
//        this.details = orderDetails;
//        this.customer = customer;
//    }
}
