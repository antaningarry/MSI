package com.wipro.orderservice.controller;

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

import com.wipro.orderservice.entity.Order;
import com.wipro.orderservice.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping("/order")
	public ResponseEntity<Order> saveOrderItem(@RequestBody Order order) {
		ResponseEntity<Order> response = null;
		if (order.getOrderId() != null) {
			response = new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		} else {
			order = service.saveOrUpdate(order);
			response = new ResponseEntity<>(order, HttpStatus.CREATED);
		}
		return response;
	}

	@GetMapping("/order")
	public ResponseEntity<List<Order>> getAllOrderItems() {
		ResponseEntity<List<Order>> response;

		List<Order> orderItems = service.getAllOrderItems();

		if (orderItems != null && orderItems.size() > 0) {
			response = new ResponseEntity<>(orderItems, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@GetMapping("/order/{id}")
	public ResponseEntity<Order> getOrderItems(@PathVariable("id") Long id) {
		ResponseEntity<Order> response;

		Order orderItem = service.getOrderItems(id);

		if (orderItem != null) {
			response = new ResponseEntity<>(orderItem, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}



	@PutMapping("/order/{id}")
	public ResponseEntity<Order> updateOrderItem(@RequestBody Order order, @PathVariable("id") Long id) {
		ResponseEntity<Order> response = null;
		order.setOrderId(id);
		Order orderFound = service.getOrderItems(id);
		if (orderFound == null) {
			response = new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		} else {
			order = service.saveOrUpdate(order);
			response = new ResponseEntity<>(order, HttpStatus.ACCEPTED);
		}
		return response;
	}

	@DeleteMapping("/order/{id}")
	public ResponseEntity<Order> deleteOrderItems(@PathVariable("id") Long id) {
		ResponseEntity<Order> response;

		Order orderItem = service.getOrderItems(id);

		if (orderItem != null) {
			service.deleteOrderItems(id);
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		}
		return response;
	}
}
