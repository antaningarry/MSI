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

import com.wipro.productms.model.Product;
import com.wipro.productms.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		ResponseEntity<Product> response=null;
		if(product.getProduct_id()!= null) {
			response = new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		} else {
			product= productService.addProduct(product);
			response = new ResponseEntity<>(product, HttpStatus.CREATED);
		}
		return response;
	}
	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllProducts() 
	{
		ResponseEntity<List<Product>> response;

		List<Product> productsList = productService.getAllProducts();

		if (productsList != null && productsList.size() > 0) {
			response = new ResponseEntity<>(productsList, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable("id") Long product_id)
	{
		ResponseEntity<Product> response;

		Product productList = productService.getProductById(product_id);

		if (productList != null) {
			response = new ResponseEntity<>(productList, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
		
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable("id") Long product_id)
	{
		ResponseEntity<Product> response = null;
		product.setProduct_id(product_id);;
		Product orderFound = productService.getProductById(product_id);
		if (orderFound == null) {
			response = new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		} else {
			product = productService.updateProduct(product);
			response = new ResponseEntity<>(product, HttpStatus.ACCEPTED);
		}
		return response;
		
		
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") long product_id)
	{
		ResponseEntity<Product> response;

		Product product =productService.getProductById(product_id);

		if (product != null) {
			productService.deleteProduct(product_id);
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		}
		return response;
		
	}
}
