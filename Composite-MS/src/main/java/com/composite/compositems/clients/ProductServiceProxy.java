package com.composite.compositems.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.composite.compositems.entity.Product;

@FeignClient(name = "product-service")
public interface ProductServiceProxy {

	@GetMapping("/product")
	public List<Product> getAllProducts();

	@GetMapping("/product/{product_id}")
	public Product getProductById(@PathVariable("product_id") long product_id);

	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product);

	@PutMapping("/product")
	public void updateProduct(@RequestBody Product product);

	@DeleteMapping("/product/{product_id}")
	public void deleteProduct(@PathVariable("product_id") long product_id);

}
