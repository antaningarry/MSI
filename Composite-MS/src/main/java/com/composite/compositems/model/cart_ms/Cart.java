package com.composite.compositems.model.cart_ms;

import java.util.List;

public class Cart {

	private Long cartId;

	private List<CartLineItem> cartLineItems;

	public Cart() {
		super();
	}

	public Cart(Long id, List<CartLineItem> cartLineItems) {
		super();
		this.cartId = id;
		this.cartLineItems = cartLineItems;
	}

	public Long getId() {
		return cartId;
	}

	public void setId(Long id) {
		this.cartId = id;
	}

	public List<CartLineItem> getcartLineItems() {
		return cartLineItems;
	}

	public void setcartLineItems(List<CartLineItem> cartLineItems) {
		this.cartLineItems = cartLineItems;
	}

}
