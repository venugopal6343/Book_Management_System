package com.Bookstore_Management_System.order.dto;

public record OrderDto(
         long id,
         CustomerDto customerDto,
         BookDto bookDto,
         int quantity,
         String status
) {
}
