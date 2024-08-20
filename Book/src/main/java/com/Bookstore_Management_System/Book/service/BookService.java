package com.Bookstore_Management_System.Book.service;


import com.Bookstore_Management_System.Book.exceptions.BookNotFoundException;
import com.Bookstore_Management_System.Book.model.Book;
import com.Bookstore_Management_System.Book.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll() ;
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Book getById(Long id){
        Optional<Book> existingBook= bookRepository.findById(id);
        if(existingBook.isPresent()){
            return existingBook.get();

        }


        throw new BookNotFoundException("Book not found");
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book updateBook){
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()){
            Book existingBook = book.get();
            existingBook.setTitle(updateBook.getTitle());
            existingBook.setAuthor(updateBook.getAuthor());
            existingBook.setPrice(updateBook.getPrice());
            existingBook.setStock(updateBook.getStock());

            return bookRepository.save(existingBook);
        }
        else{
            throw new EntityNotFoundException("Book with this id" + id+ "is not present");
        }
    }




}

//    public Book updateBookStock(Long id, int stock) {
//        Book book = bookRepo.findById(id).orElse(null);
//        if (book != null) {
//            book.setStock(stock);
//            return bookRepo.save(book);
//        } else {
//            return null;
//        }
//    }




