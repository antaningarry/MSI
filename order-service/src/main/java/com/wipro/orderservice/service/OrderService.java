package com.wipro.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.orderservice.entity.Order;
import com.wipro.orderservice.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;

	public List<Order> getAllOrderItems() {
		return repo.findAll();
	}

	public Order getOrderItems(long id) {
		return repo.findById(id).orElse(null);
	}

	public Order saveOrUpdate(Order cart) {
		return repo.save(cart);
	}

	public void deleteOrderItems(long id) {
		repo.deleteById(id);
	}

}
