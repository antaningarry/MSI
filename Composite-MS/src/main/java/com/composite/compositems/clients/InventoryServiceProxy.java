package com.composite.compositems.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.composite.compositems.model.product_inventory_ms.Inventory;

@FeignClient(name = "Inventory-service")
public interface InventoryServiceProxy {
	
	@PostMapping("/inventory")
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory);

	@GetMapping("/inventory/{product_id}")
	public Inventory findInventoryById(@PathVariable("product_id") long product_id);

	@PutMapping("/inventory/updateQty")
	public void reduceInventoryQuantity(@RequestBody Inventory request);

}
