package com.example.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(generator = "UUID",strategy = GenerationType.IDENTITY)
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private String cartId;
    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Item> itemList;

    public Cart() {
    }

    public Cart(String cartId, Customer customer, List<Item> itemList) {
        this.cartId = cartId;
        this.customer = customer;
        this.itemList = itemList;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
