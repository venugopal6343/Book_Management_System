package com.Bookstore_Management_System.order.exceptions;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String stockIsNotEnough) {
        super(stockIsNotEnough);
    }
}
