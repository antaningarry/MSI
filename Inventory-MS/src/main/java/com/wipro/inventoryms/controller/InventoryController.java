package com.wipro.inventoryms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.inventoryms.exception.ResourceNotFoundException;
import com.wipro.inventoryms.model.Inventory;
import com.wipro.inventoryms.service.InventoryService;

@RestController
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping("/inventory")
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) 
	{
		inventoryService.addInventory(inventory);
		return new ResponseEntity<Inventory>(inventory, HttpStatus.CREATED);
	}

	@GetMapping("/inventory/{product_id}")
	public ResponseEntity<Inventory> findInventoryById(@PathVariable("product_id") long product_id) 
	{
		Inventory invent = inventoryService.getInventoryById(product_id);
		if (invent == null)
			return new ResponseEntity<Inventory>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Inventory>(invent, HttpStatus.OK);
	}

	@GetMapping("/inventory")
	public List<Inventory> getAllInventories() throws ResourceNotFoundException 
	{
		List<Inventory> list = inventoryService.getAllInventories();
		if (list.size() == 0)
			throw new ResourceNotFoundException("PRODUCTS NOT FOUND");
		return inventoryService.getAllInventories();
	}

	@PutMapping("/inventory")
	public void updateInventory(@RequestBody Inventory inventory) 
	{
		inventoryService.updateInventory(inventory);

	}

	@PutMapping("/inventory/updateQty")
	public void reduceInventoryQuantity(@RequestBody Inventory request) {
		Inventory inventory = inventoryService.getInventoryById(request.getProduct_id());
		if (inventory != null) {
			int quantity = inventory.getQuantity() - request.getQuantity();
			inventory.setQuantity(quantity);
			inventoryService.updateInventory(inventory);
		}
	}

	@DeleteMapping("/inventory/{product_id}")
	public void deleteInventory(@PathVariable("product_id") long product_id) 
	{
		inventoryService.deleteInventory(product_id);
	}
}
