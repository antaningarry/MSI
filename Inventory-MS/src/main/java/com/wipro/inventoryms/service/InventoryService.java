package com.wipro.inventoryms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.inventoryms.dao.InventoryDAO;
import com.wipro.inventoryms.model.Inventory;

@Service
public class InventoryService {
	@Autowired
	private InventoryDAO dao;
	
	public List<Inventory> getAllInventories()
	{
		List<Inventory> inventories = new ArrayList<Inventory>();
		dao.findAll().forEach(inventory1->inventories.add(inventory1));
		return inventories;
	}
	
	public Inventory addInventory(Inventory inventory)
	{
		return dao.save(inventory);
	}
	public Inventory getInventoryById(long product_id)
	{
		return dao.findById(product_id).orElse(null);
	}
	
	public void updateInventory(Inventory inventory)
	{
		dao.save(inventory);
	}
	
	public void deleteInventory(long product_id)
	{
		dao.deleteById(product_id);
	}
}
