package com.example.service;

import com.example.exceptions.OrderException;
import com.example.model.Order;
import com.example.repository.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public Order addOrder(Order order) throws OrderException {
        Order order1 = orderDao.save(order);
        if (order1 == null) {
            throw new OrderException("Order Not Found");
        } else {
            return order1;
        }
    }

    @Override
    public Order viewOrder(String orderId) throws OrderException {
        Optional<Order> opt = orderDao.findById(orderId);
        if (opt.isPresent()) {
            Order ood = opt.get();
            return ood;
        } else {
            throw new OrderException("data not found....");
        }
    }

    @Override
    public Order removeOrder(String orderId) throws OrderException {
        Optional<Order> opt = orderDao.findById(orderId);
        if (opt.isPresent()) {
            Order od = opt.get();
            orderDao.delete(od);
            return od;
        } else {
            throw new OrderException("data not deleted...");
        }
    }
}
