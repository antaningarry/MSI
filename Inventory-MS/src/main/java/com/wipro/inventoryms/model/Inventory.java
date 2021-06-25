package com.wipro.inventoryms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Inventory {

	@Id
	private long product_id;
	private int quantity;
	
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Inventory(long product_id, int quantity) {
		super();
		this.product_id = product_id;
		this.quantity = quantity;
	}
	
	public Inventory() {
		
	}
	
	
}
