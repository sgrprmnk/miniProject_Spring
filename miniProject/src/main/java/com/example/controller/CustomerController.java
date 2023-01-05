package com.example.controller;

import com.example.exceptions.CustomerException;
import com.example.model.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer) throws CustomerException {
        Customer customer1=customerService.addCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
    @PutMapping("/customers/")
    public ResponseEntity<Customer> updateCustomerHandler(@RequestBody Customer customer, @RequestParam(required = false) String key) throws CustomerException {
        Customer customer1=customerService.updateCustomer(customer,key);
        return new ResponseEntity<>(customer1,HttpStatus.FOUND);
    }
    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<Customer> deleteCustomerHandler(@PathVariable("customerId") String customerId, @RequestParam(required = false) String key) String customerId){
        Customer customer=customerService.removeCustomer(customerId,key);

    }

}
