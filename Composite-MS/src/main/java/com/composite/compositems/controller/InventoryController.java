package com.composite.compositems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.composite.compositems.clients.InventoryServiceProxy;
import com.composite.compositems.model.product_inventory_ms.Inventory;

@RestController
public class InventoryController {

	@Autowired
	private InventoryServiceProxy proxy;
	
	@GetMapping("/inventory")
	public List<Inventory> getAllInventories() {
		return proxy.getAllInventories();
		
	}
	@GetMapping("/inventory/{product_id}")
	public Inventory findInventoryById(@PathVariable("product_id") long product_id) {
		return proxy.findInventoryById(product_id);
	}
	@PostMapping("/inventory")
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {
		return proxy.addInventory(inventory);
	}
	@PutMapping("/inventory")
	public void updateInventory(@RequestBody Inventory inventory) {
		 proxy.updateInventory(inventory);
	}
	@DeleteMapping("/inventory/{product_id}")
	public void deleteInventory(@PathVariable("product_id") long product_id) {
		proxy.deleteInventory(product_id);
	}
}
