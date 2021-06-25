package com.wipro.orderservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_T")
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	private Long orderId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderLineItem> orderLineItems;

	public Order() {
		super();
	}

	public Order(Long id, List<OrderLineItem> orderLineItems) {
		super();
		this.orderId = id;
		this.orderLineItems = orderLineItems;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public List<OrderLineItem> getOrderLineItems() {
		return orderLineItems;
	}

	public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}

}
