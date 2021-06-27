package com.composite.compositems.model.order_ms;

public class OrderLineItem {

	private long orderLineId;

	private long productId;

	private String productName;

	private double price;

	private long quantity;

	public OrderLineItem() {
		super();
	}

	public OrderLineItem(long orderLineId, long productId, String productName, double price, long quantity) {
		super();
		this.orderLineId = orderLineId;
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public OrderLineItem(long productId, String productName, double price, long quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public long getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(long orderLineId) {
		this.orderLineId = orderLineId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

}
