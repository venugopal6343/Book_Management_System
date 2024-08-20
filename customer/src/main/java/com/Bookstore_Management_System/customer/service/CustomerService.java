package com.Bookstore_Management_System.customer.service;

import com.Bookstore_Management_System.customer.model.Customer;
import com.Bookstore_Management_System.customer.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<Customer> getAllCustomers(){
        return  customerRepository.findAll();
    }


    public Customer getCustomerById(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            return customer.get();
        }
        throw new CustomerNotFoundException("customer not found");

    }


    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Long id, Customer updateBook){
        Optional<Customer> book = customerRepository.findById(id);
        if (book.isPresent()){
            Customer existingBook = book.get();
            existingBook.setName(updateBook.getName());
            existingBook.setEmail(updateBook.getEmail());
            existingBook.setPhoneNumber(updateBook.getPhoneNumber());

            return customerRepository.save(existingBook);
        }
        else{
            throw new CustomerNotFoundException("Book with this id" + id+ "is not present");
        }
    }
}
