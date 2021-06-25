package com.wipro.orderservice.entity;

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
	private long oid;

	@Column(name = "TOTAL_PRICE")
	private double totalPrice;

	@Column(name = "DELIVERY_ADDRESS")
	private String deliveryAddress;

	public OrderLineItem() {
		super();
	}

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

}
