package com.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.bean.InventoryItem;
import com.inventory.persistence.InventoryItemDao;

@Service
public class InventoryItemServiceImpl implements InventoryItemService {

	@Autowired
	private InventoryItemDao inventoryItemDao;
	
	@Override
	public InventoryItem getInventoryItemByProductCode(String code) {
		return inventoryItemDao.findByProductCode(code);
	}

	@Override
	public InventoryItem updateQuantityByProductCode(String code, int availableQuantity) {
		if(inventoryItemDao.updateByQuantity(code,availableQuantity)>0)
			return getInventoryItemByProductCode(code);
		return new InventoryItem();
	}

}
