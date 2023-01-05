package com.example.service;

import com.example.exceptions.CustomerException;
import com.example.model.Customer;

public interface CustomerService {
public Customer addCustomer(Customer customer) throws CustomerException;
public Customer updateCustomer(Customer customer, String key) throws CustomerException;
public Customer removeCustomer(String customerId, String key) throws CustomerException;
public Customer viewCustomer(String customerId,String key) throws CustomerException;


}
