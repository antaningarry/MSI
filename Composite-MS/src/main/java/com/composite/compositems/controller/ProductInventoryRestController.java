package com.composite.compositems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.composite.compositems.clients.InventoryServiceProxy;
import com.composite.compositems.clients.ProductServiceProxy;
import com.composite.compositems.model.product_inventory_ms.Inventory;
import com.composite.compositems.model.product_inventory_ms.Product;
import com.composite.compositems.model.product_inventory_ms.ProductData;

@RestController
public class ProductInventoryRestController {

	@Autowired
	private ProductServiceProxy proxy;
	
	@Autowired
	private InventoryServiceProxy inventoryProxy;
	
	@PostMapping("/product")
	public ProductData addProduct(@RequestBody ProductData productdata) 
	{
		ResponseEntity<Product> productResponse = proxy.addProduct(new Product(productdata.getProduct_name(), productdata.getPrice()));
		Product product = productResponse.getBody();
		ResponseEntity<Inventory> inventoryResponse = inventoryProxy.addInventory(new Inventory(product.getProduct_id(), productdata.getQuantity()));
		Inventory inventory = inventoryResponse.getBody();
		return new ProductData(product.getProduct_id(), product.getProduct_name(), product.getPrice(), inventory.getQuantity());
	}
	
	@GetMapping("/product/{product_id}")
	public ProductData findProductById(@PathVariable("product_id") long product_id)
	{
		Product productResponse = proxy.findProductById(product_id);
		Inventory inventoryResponse = inventoryProxy.findInventoryById(product_id);
		return new ProductData(productResponse.getProduct_id(), productResponse.getProduct_name(), productResponse.getPrice(), inventoryResponse.getQuantity());
	}

}
