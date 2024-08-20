package com.Bookstore_Management_System.customer.repository;

import com.Bookstore_Management_System.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
