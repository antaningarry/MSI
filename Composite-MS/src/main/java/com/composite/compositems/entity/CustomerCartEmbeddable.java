package com.composite.compositems.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerCartEmbeddable implements Serializable {
	
	
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "cart_id")
	private Long cartId;
	
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	
	public CustomerCartEmbeddable() {
		super();
	}
	public CustomerCartEmbeddable(Long customerId, Long cartId) {
		super();
		this.customerId = customerId;
		this.cartId = cartId;
	}
	
	
	
	

}
