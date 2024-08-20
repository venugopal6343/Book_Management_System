package com.Bookstore_Management_System.order.feign_clients;


import com.Bookstore_Management_System.order.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//http://localhost:9800/customers/1
@FeignClient(name = "customer",url="http://localhost:9800")
public interface CustomerClient {

    @GetMapping("/customers/{id}")
    CustomerDto getCustomerById(@PathVariable("id") long id);
}
