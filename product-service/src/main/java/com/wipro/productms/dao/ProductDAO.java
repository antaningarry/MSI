package com.wipro.productms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.productms.model.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {
	
}
