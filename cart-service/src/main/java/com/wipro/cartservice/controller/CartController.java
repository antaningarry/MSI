package com.wipro.cartservice.controller;

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

import com.wipro.cartservice.entity.Cart;
import com.wipro.cartservice.entity.CartLineItem;
import com.wipro.cartservice.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService service;

	@GetMapping("/cart")
	public ResponseEntity<List<Cart>> getAllCartItems() {
		ResponseEntity<List<Cart>> response;

		List<Cart> cartItems = service.getAllCartItems();

		if (cartItems != null && cartItems.size() > 0) {
			response = new ResponseEntity<>(cartItems, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@GetMapping("/cart/{id}")
	public ResponseEntity<Cart> getCartItems(@PathVariable("id") Long id) {
		ResponseEntity<Cart> response;

		Cart cartItem = service.getCartItems(id);

		if (cartItem != null) {
			response = new ResponseEntity<>(cartItem, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}

	@PostMapping("/cart")
	public ResponseEntity<Cart> saveCartItem(@RequestBody Cart cart) {
		ResponseEntity<Cart> response = null;
		if (cart.getCartId() != null) {
			response = new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		} else {
			cart = service.saveOrUpdate(cart);
			response = new ResponseEntity<>(cart, HttpStatus.CREATED);
		}
		return response;
	}

	@PutMapping("/cart/{id}")
	public ResponseEntity<Cart> updateCartItem(@RequestBody Cart cart, @PathVariable("id") Long id) {
		ResponseEntity<Cart> response = null;
		Cart cartFound = service.getCartItems(id);
		if (cartFound == null) {
			response = new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		} else {
			cart = service.saveOrUpdate(cart);
			response = new ResponseEntity<>(cart, HttpStatus.ACCEPTED);
		}
		return response;
	}
	
	@DeleteMapping("/cart/{id}/cartItems")
	public ResponseEntity<Cart> deleteCartLineItems(@PathVariable("id") Long id) {
		ResponseEntity<Cart> response = null;
		Cart cartFound = service.getCartItems(id);
		if (cartFound == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			List<CartLineItem> lineItems = cartFound.getcartLineItems();
			cartFound.setcartLineItems(null);;
			cartFound = service.saveOrUpdate(cartFound);
			lineItems.forEach(li -> {
				service.deleteCartLineItems(li.getOid());
			});
			response = new ResponseEntity<>(cartFound, HttpStatus.ACCEPTED);
		}
		return response;
	}

	@DeleteMapping("/cart/{id}")
	public ResponseEntity<Cart> deleteCartItems(@PathVariable("id") Long id) {
		ResponseEntity<Cart> response;

		Cart cartItem = service.getCartItems(id);

		if (cartItem != null) {
			service.deleteCartItems(id);
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		}
		return response;
	}
}
