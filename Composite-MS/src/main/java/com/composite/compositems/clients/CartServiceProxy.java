package com.composite.compositems.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.composite.compositems.model.cart_ms.Cart;



@FeignClient(name="Cart-Service")
public interface CartServiceProxy {
	
	@PostMapping("/cart")
	public Cart saveCartItem(@RequestBody Cart cart);
	
	@GetMapping("/cart/{id}")
	public ResponseEntity<Cart> getCartItems(@PathVariable("id") Long id);

}
