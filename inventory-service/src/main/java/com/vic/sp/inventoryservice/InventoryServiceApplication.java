package com.vic.sp.inventoryservice;

import com.vic.sp.inventoryservice.model.Inventory;
import com.vic.sp.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
 		return args -> {
			 Inventory inventory = new Inventory();
			 inventory.setSkuCode("iphone_15");
			 inventory.setQuantity(100);

			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("iphone_15_pro_max");
			inventory2.setQuantity(0);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory2);
		};
	}

}
