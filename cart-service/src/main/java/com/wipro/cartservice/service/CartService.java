package com.wipro.cartservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.cartservice.entity.Cart;
import com.wipro.cartservice.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository repo;

	public List<Cart> getAllCartItems() {
		return repo.findAll();
	}

	public Cart getCartItems(long id) {
		return repo.findById(id).orElse(null);
	}

	public Cart saveOrUpdate(Cart cart) {
		return repo.save(cart);
	}

	public void deleteCartItems(long id) {
		repo.deleteById(id);
	}

}
