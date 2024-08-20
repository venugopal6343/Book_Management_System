package com.Bookstore_Management_System.order.controller;


import com.Bookstore_Management_System.order.dto.BookDto;
import com.Bookstore_Management_System.order.dto.OrderDto;
import com.Bookstore_Management_System.order.exceptions.OutOfStockException;
import com.Bookstore_Management_System.order.feign_clients.BookClient;
import com.Bookstore_Management_System.order.feign_clients.CustomerClient;
import com.Bookstore_Management_System.order.model.Order;
import com.Bookstore_Management_System.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    private final OrderService orderService;
    private final BookClient bookClient;
    private final CustomerClient customerClient;


    public OrderController(OrderService orderService, BookClient bookClient, CustomerClient customerClient) {
        this.orderService = orderService;
        this.bookClient = bookClient;
        this.customerClient = customerClient;
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public OrderDto getOrderById(@PathVariable long id){
        Order order= orderService.getOrderById(id);
        BookDto bookDto=bookClient.getBookById(order.getBookId());

        if(bookDto.stock()<order.getQuantity()){
            throw new OutOfStockException("Stock is not enough");
        }

        OrderDto dto=new OrderDto(
                order.getId(),
                customerClient.getCustomerById(order.getCustomerId()),
                bookClient.getBookById(order.getBookId()),
                order.getQuantity(),
                order.getStatus()
        );
        return dto;
    }


     @PostMapping("/orders")
    public Order saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
     }

     @PutMapping("/orders/{id}")
    public Order updateOrder(@PathVariable long id , @RequestBody Order order){
        return orderService.updateOrder(id ,order);
     }

     @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable long id){
        orderService.deleteOrder(id);
     }

}
