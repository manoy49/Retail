package com.sample.shop.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long storeId;
    @NotNull
    @Length(min = 5, max = 50)
    private String name;
    @ManyToOne
    @JoinColumn
    private Retailer retailer;

    public Store(String name, Retailer retailer) {
        this.name = name;
        this.retailer = retailer;
    }
    protected Store() {

    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Retailer getRetailer() {
        return retailer;
    }

    public void setRetailer(Retailer retailer) {
        this.retailer = retailer;
    }
}
