package com.wipro.microservice.CustomerService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.microservice.CustomerService.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

	

}
