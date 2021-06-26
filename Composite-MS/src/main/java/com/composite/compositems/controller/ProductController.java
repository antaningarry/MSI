package com.composite.compositems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.composite.compositems.clients.ProductServiceProxy;
import com.composite.compositems.entity.Product;

@RestController
public class ProductController {
	@Autowired
	private ProductServiceProxy proxy;
	
	@GetMapping("/product")
	public List<Product> getAllProducts() {
		return proxy.getAllProducts();
		
	}
	@GetMapping("/product/{product_id}")
	public Product getProductById(@PathVariable("product_id") long product_id) {
		return proxy.getProductById(product_id);
	}
	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return proxy.addProduct(product);
	}
	@PutMapping("/product")
	public void updateProduct(@RequestBody Product product) {
		 proxy.updateProduct(product);
	}
	@DeleteMapping("/product/{product_id}")
	public void deleteProduct(@PathVariable("product_id") long product_id) {
		proxy.deleteProduct(product_id);
	}
}
