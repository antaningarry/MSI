package com.wipro.microservice.CustomerService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.wipro.microservice.CustomerService.Entity.Customer;
import com.wipro.microservice.CustomerService.Service.CustomerService;



@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	

	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer)
	{
		ResponseEntity<Customer> response = null;
		if (customer.getCustomerId() != null) {
			response = new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		} else {
			customer= customerService.CreateCustomer(customer);
			response = new ResponseEntity<>(customer, HttpStatus.CREATED);
		}
		return response;
		
	
	}
	 
	
	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllCustomerDetails()
	{
		ResponseEntity<List<Customer>> response;

		List<Customer> customerList = customerService.getAllCustomerDetails();

		if (customerList != null && customerList.size() > 0) {
			response = new ResponseEntity<>(customerList, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
		 
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Long customerId)
	{
		ResponseEntity<Customer> response;

		Customer customer = customerService.findCustomerById(customerId);

		if (customer != null) {
			response = new ResponseEntity<>(customer, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> UpdateCustomerDetails(@RequestBody Customer customer,@PathVariable("id") Long customerId)
	{
		ResponseEntity<Customer> response = null;
		customer.setCustomerId(customerId);;
		Customer customerFound =customerService.findCustomerById(customerId);
		if (customerFound == null) {
			response = new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		} else {
			customer = customerService.updateCustomer(customer);
			response = new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
		}
		return response;
		
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long customerId)
	{
		ResponseEntity<Customer> response;

		Customer customer= customerService.findCustomerById(customerId);

		if (customer != null) {
			customerService.removeCustomer(customerId);
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		}
		return response;
		
		
	}
	
	

}
