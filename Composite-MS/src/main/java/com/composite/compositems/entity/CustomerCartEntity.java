package com.composite.compositems.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="customer_cart")
public class CustomerCartEntity {
	
	
	@EmbeddedId
	private CustomerCartEmbeddable id;

	public CustomerCartEmbeddable getId() {
		return id;
	}

	public void setId(CustomerCartEmbeddable id) {
		this.id = id;
	}

	public CustomerCartEntity(CustomerCartEmbeddable id) {
		super();
		this.id = id;
	}

	public CustomerCartEntity() {
		super();
	}

	

}
