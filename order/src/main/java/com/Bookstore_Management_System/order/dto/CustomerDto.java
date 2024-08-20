package com.Bookstore_Management_System.order.dto;

public record CustomerDto(
        long id,
        String name,
        String email,
        long phoneNumber
) {
}
