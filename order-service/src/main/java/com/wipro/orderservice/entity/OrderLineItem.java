package com.wipro.orderservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_LINE_ITEM")
public class OrderLineItem {

	@Id
	@GeneratedValue(generator = "order_line_seq")
	@SequenceGenerator(name = "order_line_seq", sequenceName = "ORDER_LINE_SEQ", allocationSize = 1)
	@Column(name = "ORDER_LINE_ITEM_ID")
	private long orderLineId;

	@Column(name = "PRODUCT_ID")
	private long productId;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "PRICE")
	private double price;

	@Column(name = "QUANTITY")
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
