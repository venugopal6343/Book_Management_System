package com.Bookstore_Management_System.order.feign_clients;

import com.Bookstore_Management_System.order.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "Book",url="http://localhost:8500")
public interface BookClient {

    @GetMapping("/books/{id}")
    BookDto getBookById(@PathVariable("id") long id);


}
