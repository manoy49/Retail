package com.sample.shop.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class Retailer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotNull
    @Length(min = 10, max = 15)
    private String phoneNumber;
    @NotNull()
    @Length(min = 4, max = 12)
    private String storeType;
    @NotNull
    @Length(min = 10, max = 500)
    private String storeAddress;

    @OneToMany(mappedBy = "retailer", cascade = CascadeType.ALL)
    private Set<Store> stores;

    public Retailer(String phoneNumber, String storeType, String storeAddress, Store stores) {
            this.phoneNumber = phoneNumber;
            this.storeType = storeType;
            this.storeAddress = storeAddress;
            this.stores = Stream.of(stores).collect(Collectors.toSet());
            this.stores.forEach(book -> book.setRetailer(this));
    }

    protected Retailer() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }
}
