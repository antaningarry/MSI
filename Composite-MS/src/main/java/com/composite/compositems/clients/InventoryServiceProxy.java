package com.composite.compositems.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.composite.compositems.entity.Inventory;

@FeignClient(name = "Inventory-MS")
public interface InventoryServiceProxy {

	@GetMapping("/inventory")
	public List<Inventory> getAllInventories();

	@GetMapping("/inventory/{product_id}")
	public Inventory findInventoryById(@PathVariable("product_id") long product_id);

	@PostMapping("/inventory")
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory);

	@PutMapping("/inventory")
	public void updateInventory(@RequestBody Inventory inventory);

	@DeleteMapping("/inventory/{product_id}")
	public void deleteInventory(@PathVariable("product_id") long product_id);
}
