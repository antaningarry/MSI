package com.wipro.orderservice.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_DATA")
public class Order {

	@Id
	@GeneratedValue(generator = "order_seq")
	@SequenceGenerator(name = "order_seq", sequenceName = "ORDER_SEQ", allocationSize = 1)
	@Column(name = "ORDER_ID")
	private Long orderId;

	@Column(name = "ORDER_DATE")
	private LocalDate orderDate;

	@Column(name = "TOTAL_PRICE")
	private double totalPrice;

	@Column(name = "DELIVERY_ADDRESS")
	private String deliveryAddress;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
		name = "ORDER_DATA_ORDER_LINE_ITEMS", 
		joinColumns = @JoinColumn(name = "ORDER_ID"), 
		inverseJoinColumns = @JoinColumn(name = "ORDER_LINE_ID")
	)
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
	
	public Order(LocalDate orderDate, double totalPrice, String deliveryAddress,
			List<OrderLineItem> orderLineItems) {
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
