package com.composite.compositems.model.cart_ms;

import java.util.List;

public class CartRequestDto {
	
	private Long cartId;
	

	private List<CartList> cartList;

	public List<CartList> getCartList() {
		return cartList;
	}

	public void setCartList(List<CartList> cartList) {
		this.cartList = cartList;
	}
	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
}
