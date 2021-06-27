package com.composite.compositems.model.cart_ms;

public class CartLineItem {

	private Long oid;

	private Long productId;

	private String productName;

	private int quantity;

	private double price;

	public CartLineItem() {
		super();
	}

	public CartLineItem(long oid, long productId, String productName, int quantity, double price) {
		super();
		this.oid = oid;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getprice() {
		return price;
	}

	public void setprice(double price) {
		this.price = price;
	}

}
