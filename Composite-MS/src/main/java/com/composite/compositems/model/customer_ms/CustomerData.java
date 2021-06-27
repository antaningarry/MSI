package com.composite.compositems.model.customer_ms;

import javax.persistence.Id;

public class CustomerData {

	private String customerName;
	private String email;
	private String billingAddress;
	private String shippingAddress;
	private Long cartId;

	public CustomerData(Long customerId, String customerName, String email, String billingAddress,
			String shippingAddress, Long cartId) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
		this.cartId = cartId;
	}

	public CustomerData(Long customerId, Long cartId) {
		super();
		this.customerId = customerId;
		this.cartId = cartId;

	}

	public CustomerData() {
		super();
	}

	@Id
	private Long customerId;

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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
