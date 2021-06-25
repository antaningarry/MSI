package com.wipro.inventoryms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class InventoryMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryMsApplication.class, args);
	}

}
