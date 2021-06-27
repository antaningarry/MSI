package com.composite.compositems.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.composite.compositems.model.order_ms.Order;

@FeignClient(name = "order-service")
public interface OrderServiceProxy {

	@PostMapping("/order")
	public ResponseEntity<Order> saveOrderItem(@RequestBody Order order);

	@GetMapping("/order/{id}")
	public ResponseEntity<Order> getOrderItems(@PathVariable("id") Long id);

	@PostMapping("/order/list")
	public ResponseEntity<List<Order>> getOrderItemsList(@RequestBody List<Long> orderIdList);

}
