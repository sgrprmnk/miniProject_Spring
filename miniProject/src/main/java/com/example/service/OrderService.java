package com.example.service;

import com.example.exceptions.OrderException;
import com.example.model.Order;

public interface OrderService {
    public Order addOrder(Order order) throws OrderException;
    public Order viewOrder(String orderId) throws OrderException;
    public Order removeOrder(String orderId) throws OrderException;
}
