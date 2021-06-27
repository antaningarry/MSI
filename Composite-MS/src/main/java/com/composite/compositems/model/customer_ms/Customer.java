package com.composite.compositems.model.customer_ms;




public class Customer { 
	
	private Long customerId;
	private String customerName;
	private String email;
	private String billingAddress;
	private String shippingAddress;
	
	public Customer(String customerName, String email, String shippingAddress, String billingAddress) {
		super();
		this.customerName=customerName;
		this.email=email;
		this.shippingAddress=shippingAddress;
		this.billingAddress=billingAddress;
		
	}
	@Override
	public String toString() {
		
		return "Customer [ customerId=" + customerId + ",customerName=" + customerName +"]" ;
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
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	

}
