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
public class Cart {

	@Id
	@GeneratedValue
	@Column(name = "CART_ID")
	private Long cartId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CartLineItem> cartLineItems;

	public Cart() {
		super();
	}

	public Cart(Long id, List<CartLineItem> cartLineItems) {
		super();
		this.cartId = id;
		this.cartLineItems = cartLineItems;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public List<CartLineItem> getcartLineItems() {
		return cartLineItems;
	}

	public void setcartLineItems(List<CartLineItem> cartLineItems) {
		this.cartLineItems = cartLineItems;
	}

}
