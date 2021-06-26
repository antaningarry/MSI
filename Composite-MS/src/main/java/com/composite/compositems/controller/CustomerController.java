package com.composite.compositems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.composite.compositems.clients.CustomerServiceProxy;
import com.composite.compositems.entity.Customer;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerServiceProxy proxy;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
	{
		return proxy.createCustomer(customer);
	}
	
	@GetMapping("/customer/{id}")
	public Customer findCustomerById(@PathVariable("id") Long customerId)
	{
		return proxy.findCustomerById(customerId);
	}

}
