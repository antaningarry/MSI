package com.composite.compositems.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerOrderEmbeddable implements Serializable {

	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "order_id")
	private Long orderId;

	public CustomerOrderEmbeddable() {
		super();
	}

	public CustomerOrderEmbeddable(Long customerId, Long orderId) {
		super();
		this.customerId = customerId;
		this.orderId = orderId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

}
