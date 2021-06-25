package com.wipro.cartservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_LINE_ITEM")
public class OrderLineItem {

	@Id
	@GeneratedValue
	@Column(name = "ORDER_LINE_ITEM_ID")
	private Long oid;

	@Column(name = "PRODUCT_ID")
	private Long productId;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "QTY")
	private int quantity;

	@Column(name = "TOTAL_PRICE")
	private double totalPrice;

	public OrderLineItem() {
		super();
	}

	public OrderLineItem(long oid, long productId, String productName, int quantity, double totalPrice) {
		super();
		this.oid = oid;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
