package com.wipro.productms.controller;

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

import com.wipro.productms.exception.ResourceNotFoundException;
import com.wipro.productms.model.Product;
import com.wipro.productms.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		productService.addProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
	}
	
	@GetMapping("/product/{product_id}")
	public ResponseEntity<Product> findProductById(@PathVariable("product_id") long product_id)
	{
		Product prod = productService.getProductById(product_id);
		if(prod == null)
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Product>(prod, HttpStatus.OK);
	}
	
	@GetMapping("/product")
	public List<Product> getAllProducts() throws ResourceNotFoundException
	{
		List<Product> list = productService.getAllProducts();
		if(list.size()==0)
			throw new ResourceNotFoundException("PRODUCTS NOT FOUND");
		return productService.getAllProducts();
	}
	
	@PutMapping("/product")
	public void updateProduct(@RequestBody Product product)
	{
		productService.updateProduct(product);
		
	}
	
	@DeleteMapping("/product/{product_id}")
	public void deleteProduct(@PathVariable("product_id") long product_id)
	{
		productService.deleteProduct(product_id);
	}
}
