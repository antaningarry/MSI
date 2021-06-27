package com.wipro.microservice.CustomerService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.microservice.CustomerService.Entity.Customer;
import com.wipro.microservice.CustomerService.Repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public Customer CreateCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}

//	public Customer saveCustomer(Customer customer) {
//		// TODO Auto-generated method stub
//		return customerRepository.save(customer);
//	}

	public Customer findCustomerById(Long customerId) {
		return customerRepository.findById(customerId).orElse(null);
	}

	public void removeCustomer(Long customerId) {
		customerRepository.deleteById(customerId);
	}

	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> getAllCustomerDetails() {
		List<Customer> customers=new ArrayList<Customer>();
		customerRepository.findAll().forEach(customers1 -> customers.add(customers1));
		return customers;
	}

}
