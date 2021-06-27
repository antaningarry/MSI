package com.composite.compositems.model.order_ms;

import java.time.LocalDate;
import java.util.List;

public class Order {

	private Long orderId;

	private LocalDate orderDate;

	private double totalPrice;

	private String deliveryAddress;

	private List<OrderLineItem> orderLineItems;

	public Order() {
		super();
	}

	public Order(Long orderId, LocalDate orderDate, double totalPrice, String deliveryAddress,
			List<OrderLineItem> orderLineItems) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.deliveryAddress = deliveryAddress;
		this.orderLineItems = orderLineItems;
	}

	public Order(LocalDate orderDate, double totalPrice, String deliveryAddress, List<OrderLineItem> orderLineItems) {
		super();
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.deliveryAddress = deliveryAddress;
		this.orderLineItems = orderLineItems;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<OrderLineItem> getOrderLineItems() {
		return orderLineItems;
	}

	public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}

}
