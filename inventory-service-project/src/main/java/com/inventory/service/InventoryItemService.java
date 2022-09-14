package com.inventory.service;

import com.inventory.bean.InventoryItem;

public interface InventoryItemService {

	InventoryItem getInventoryItemByProductCode(String code);
	InventoryItem updateQuantityByProductCode(String code,int availableQuantity);
}
