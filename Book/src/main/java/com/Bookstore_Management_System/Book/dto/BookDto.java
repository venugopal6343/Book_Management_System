package com.Bookstore_Management_System.Book.dto;

public record BookDto(
        long id,
        String title,
        String author,
        long price,
        long stock
) {
}
