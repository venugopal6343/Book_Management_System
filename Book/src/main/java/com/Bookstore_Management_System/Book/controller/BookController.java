package com.Bookstore_Management_System.Book.controller;


import com.Bookstore_Management_System.Book.converter.BookDtoConverter;
import com.Bookstore_Management_System.Book.dto.BookDto;
import com.Bookstore_Management_System.Book.model.Book;
import com.Bookstore_Management_System.Book.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final BookService bookService;
    private final BookDtoConverter converter;

    public BookController(BookService bookService, BookDtoConverter converter) {
        this.bookService = bookService;
        this.converter = converter;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/books/{id}")
    public BookDto getBookById(@PathVariable long id){
        return converter.convertToDto(bookService.getById(id));
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updateBook){
        return ResponseEntity.ok(bookService.updateBook(id,updateBook));
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);

    }


}