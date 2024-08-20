package com.Bookstore_Management_System.order.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String orderNotFound) {
        super(orderNotFound);
    }
}
