package com.practice.order.Repository;

import com.practice.order.Entity.Customer;
import com.practice.order.Entity.OrderEntry;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntry, Long> {
    List<OrderEntry> findByCustomer(Customer customer);
    List<OrderEntry> findOrderByDetails(String details);
    List<OrderEntry> findOrderByNumberOfItems(Integer numberOfItems);
    List<OrderEntry> findOrdersByDetailsAndNumberOfItems(String details, Integer numberOfItems);
}
