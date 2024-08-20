package com.Bookstore_Management_System.order.service;


import com.Bookstore_Management_System.customer.service.CustomerNotFoundException;
import com.Bookstore_Management_System.order.exceptions.OrderNotFoundException;
import com.Bookstore_Management_System.order.model.Order;
import com.Bookstore_Management_System.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(long id){
        Optional<Order> order= orderRepository.findById(id);
        if (order.isPresent())
            return order.get();
        throw new OrderNotFoundException("Order not found");
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(long id , Order order){
        Optional<Order> getorder = orderRepository.findById(id);
        if(getorder.isPresent()){
            Order finalOrder=getorder.get();
            finalOrder.setQuantity(order.getQuantity());
            finalOrder.setStatus(order.getStatus());
            return orderRepository.save(finalOrder);

        }
        else{
            throw new CustomerNotFoundException("Book with this id" + id+ "is not present");
        }
    }

    public void deleteOrder(long id){
        orderRepository.deleteById(id);

    }

}
