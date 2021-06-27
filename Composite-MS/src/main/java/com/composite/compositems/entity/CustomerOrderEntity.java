package com.composite.compositems.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer_order")
public class CustomerOrderEntity {

	@EmbeddedId
	private CustomerOrderEmbeddable id;

	public CustomerOrderEntity(CustomerOrderEmbeddable id) {
		super();
		this.id = id;
	}

	public CustomerOrderEntity() {
		super();
	}

	public CustomerOrderEmbeddable getId() {
		return id;
	}

	public void setId(CustomerOrderEmbeddable id) {
		this.id = id;
	}

}
