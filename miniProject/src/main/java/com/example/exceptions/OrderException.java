package com.example.exceptions;

public class OrderException extends Exception{
    public OrderException() {
    }

    public OrderException(String message) {
        super(message);
    }
}
