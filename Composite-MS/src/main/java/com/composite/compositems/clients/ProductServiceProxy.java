package com.composite.compositems.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.composite.compositems.model.product_inventory_ms.Product;

@FeignClient(name = "product-service")
public interface ProductServiceProxy {
	
	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product);

	@GetMapping("/product/{product_id}")
	public Product findProductById(@PathVariable("product_id") long product_id);

}
