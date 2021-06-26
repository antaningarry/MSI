package com.composite.compositems.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.composite.compositems.entity.Customer;

@FeignClient(name="Customer-Service")
public interface CustomerServiceProxy {
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer);
	
	@GetMapping("/customer/{id}")
	public Customer findCustomerById(@PathVariable("id") Long customerId);

}
