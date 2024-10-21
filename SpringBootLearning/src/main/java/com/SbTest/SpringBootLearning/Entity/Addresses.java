package com.SbTest.SpringBootLearning.Entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

@Entity
//@Table(name = "Addresses")
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Number")
    private Integer number;
    private String street;
    private String postcode;

    public Addresses(String postcode, String street, int number) {
        this.postcode = postcode;
        this.street = street;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}