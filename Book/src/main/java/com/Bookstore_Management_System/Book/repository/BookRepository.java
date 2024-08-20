package com.Bookstore_Management_System.Book.repository;

import com.Bookstore_Management_System.Book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
