package com.catalog.main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inventory.bean.InventoryItem;
import com.inventory.persistence.InventoryItemDao;

@SpringBootTest(classes = com.inventory.main.InventoryServiceProjectApplication.class)
public class InventoryDaoTest {
	
	@Autowired
	InventoryItemDao inventoryDao;
	
	class TestFindByProductCode{
		@Test
		public void findByProductCode_T001() {
			InventoryItem item=new InventoryItem(101, "P001", 217);
			List<InventoryItem> expected=Arrays.asList(item);
			assertEquals(expected, inventoryDao.findByProductCode("P001"));
		}
		@Test
		public void findByProductCode_T002() {
			List<InventoryItem> expected=new ArrayList<>();
			assertEquals(expected, inventoryDao.findByProductCode("P099"));
		}
	}
	
	@Nested
	class TestUpdateInventoryItemQuantityByProductCode{
		@Test
		public void update_T001() {
			assertEquals(1,inventoryDao.updateByQuantity("P001", 200));
		}
		
		@Test
		public void update_T002() {
			assertEquals(1,inventoryDao.updateByQuantity("P001", 0));
		}
		
		@Test
		public void update_T003() {
			assertEquals(0,inventoryDao.updateByQuantity("P099", 200));
		}
		
		@Test
		public void update_T004() {
			assertEquals(0,inventoryDao.updateByQuantity("P099", 0));
		}
	}
}
