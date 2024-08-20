package com.Bookstore_Management_System.order.repository;

import com.Bookstore_Management_System.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
