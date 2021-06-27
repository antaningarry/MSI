package com.wipro.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.cartservice.entity.CartLineItem;

public interface CartLineItemRepository extends JpaRepository<CartLineItem, Long> {

}
