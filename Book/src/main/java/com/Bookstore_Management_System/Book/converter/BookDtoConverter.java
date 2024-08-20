package com.Bookstore_Management_System.Book.converter;

import com.Bookstore_Management_System.Book.dto.BookDto;
import com.Bookstore_Management_System.Book.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDtoConverter {

    public BookDto convertToDto(Book book){
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPrice(),
                book.getStock()
        );
    }

}
