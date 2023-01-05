package com.example.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Order {
    @Id
    @GeneratedValue(generator = "UUID",strategy = GenerationType.IDENTITY)
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private String orderId;
    private LocalDate localDate;
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;
    private String orderStatus;

    public Order() {
    }

    public Order(String orderId, LocalDate localDate, Cart cart, String orderStatus) {
        this.orderId = orderId;
        this.localDate = localDate;
        this.cart = cart;
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", localDate=" + localDate +
                ", cart=" + cart +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
