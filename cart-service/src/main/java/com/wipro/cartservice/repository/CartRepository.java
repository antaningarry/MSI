package com.wipro.cartservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.cartservice.entity.Order;

@Repository
public interface CartRepository extends JpaRepository<Order, Long> {

}
