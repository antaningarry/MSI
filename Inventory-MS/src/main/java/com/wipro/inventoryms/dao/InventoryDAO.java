package com.wipro.inventoryms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wipro.inventoryms.model.Inventory;

@Repository
public interface InventoryDAO extends JpaRepository<Inventory, Long> {

}
