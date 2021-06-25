package com.wipro.inventoryms.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.wipro.inventoryms.model.Inventory;

@Repository
public interface InventoryDAO extends CrudRepository<Inventory, Long> {

}
