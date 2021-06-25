package com.wipro.cartservice.entity;

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
@Table(name = "CART")
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "CART_ID")
	private Long cartId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<OrderLineItem> orderLineItems;

	public Order() {
		super();
	}

	public Order(Long id, List<OrderLineItem> orderLineItems) {
		super();
		this.cartId = id;
		this.orderLineItems = orderLineItems;
	}

	public Long getId() {
		return cartId;
	}

	public void setId(Long id) {
		this.cartId = id;
	}

	public List<OrderLineItem> getOrderLineItems() {
		return orderLineItems;
	}

	public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}

}
