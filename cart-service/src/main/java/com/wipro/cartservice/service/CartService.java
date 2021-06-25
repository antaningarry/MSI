package com.wipro.cartservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.cartservice.entity.Order;
import com.wipro.cartservice.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository repo;

	public List<Order> getAllCartItems() {
		return repo.findAll();
	}

	public Order getCartItems(long id) {
		return repo.findById(id).orElse(null);
	}

	public Order saveOrUpdate(Order cart) {
		return repo.save(cart);
	}

	public void deleteCartItems(long id) {
		repo.deleteById(id);
	}

}
