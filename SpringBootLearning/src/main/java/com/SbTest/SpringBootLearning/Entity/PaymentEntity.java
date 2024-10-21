package com.SbTest.SpringBootLearning.Entity;

import org.springframework.stereotype.Component;

public class PaymentEntity {
    private long id;
    private String name;
    private String details;

    public String getDetails() {
        return details;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
