package com.composite.compositems.model.order_ms;

import java.util.List;

public class OrderResponse {
	private Long customerId;

	private List<Order> orders;

	public OrderResponse() {
		super();
	}

	public OrderResponse(Long customerId, List<Order> orders) {
		super();
		this.customerId = customerId;
		this.orders = orders;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
