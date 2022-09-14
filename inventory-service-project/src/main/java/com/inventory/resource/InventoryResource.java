package com.inventory.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.bean.InventoryItem;
import com.inventory.service.InventoryItemServiceImpl;

@RestController
public class InventoryResource {
	
	@Autowired
	private InventoryItemServiceImpl inventoryItemServiceImpl;

	@GetMapping(path = "/code/{productCode}",produces = MediaType.APPLICATION_JSON_VALUE)
	public InventoryItem getInventoryItemByProductCode (String productCode) {
		InventoryItem item=inventoryItemServiceImpl.getInventoryItemByProductCode(productCode);
		if(item!=null) {
			return item;
		}
		return new InventoryItem();
	} 
	
	@PutMapping(path = "/code/{productCode}/{availableQuantity }",produces = MediaType.APPLICATION_JSON_VALUE)
	public InventoryItem updateInventoryItemQuantityByProductCode(String productCode, int availableQuantity) {
		InventoryItem item=inventoryItemServiceImpl.updateQuantityByProductCode(productCode, availableQuantity);
		if(item!=null) {
			return item;
		}
		return new InventoryItem();
	}
}
