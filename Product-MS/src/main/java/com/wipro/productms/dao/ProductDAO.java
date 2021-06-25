package com.wipro.productms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.productms.model.Product;

@Repository
public interface ProductDAO extends CrudRepository<Product, Long> {
	
}
