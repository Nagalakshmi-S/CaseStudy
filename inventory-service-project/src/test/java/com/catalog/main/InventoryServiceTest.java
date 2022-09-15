package com.catalog.main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inventory.bean.InventoryItem;
import com.inventory.persistence.InventoryItemDao;
import com.inventory.service.InventoryItemServiceImpl;

@SpringBootTest(classes = com.inventory.main.InventoryServiceProjectApplication.class)
@RunWith(MockitoJUnitRunner.class)
class InventoryServiceTest {

	@Autowired
	@InjectMocks
	InventoryItemServiceImpl inventoryService;
	
	@Mock
	InventoryItemDao inventoryDao;
	
	private AutoCloseable closeable;
	
	@BeforeEach
	void setUp() throws Exception {
		closeable=MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
		closeable.close();
	}

	@Nested
	class TestFindByProductCode{
		@Test
		public void findByProductCode_T001() {
			InventoryItem expected=new InventoryItem(101, "P001", 217);
			
			Mockito.when(inventoryDao.findByProductCode("P001")).thenReturn(expected);
			
			assertEquals(expected, inventoryService.getInventoryItemByProductCode("P001"));
		}
		
		@Test
		public void findByProductCode_T002() {
			InventoryItem emptyList=new InventoryItem();
			Mockito.when(inventoryDao.findByProductCode("P099")).thenReturn(emptyList);
			
			InventoryItem expected=new InventoryItem();
			assertEquals(expected, inventoryService.getInventoryItemByProductCode("P099"));
		}
	}
	
	@Nested
	class TestUpdateInventoryItemQuantityByProductCode{
		@Test
		public void update_T001() {
			Mockito.when(inventoryDao.updateByQuantity("P001", 200)).thenReturn(1);
			InventoryItem expected=new InventoryItem(101, "P001", 217);
			Mockito.when(inventoryDao.findByProductCode("P001")).thenReturn(expected);
			assertTrue(inventoryService.updateQuantityByProductCode("P001", 200));
		}
		
		@Test
		public void update_T002() {
			Mockito.when(inventoryDao.updateByQuantity("P001", 0)).thenReturn(1);
			
			assertFalse(inventoryService.updateQuantityByProductCode("P001", 0));
		}
		
		//negative cases
		@Test
		public void update_T003() {
//			Mockito.when(inventoryDao.updateInventoryItemQuantityByProductCode("P001", -200)).thenReturn(0);
			
			assertFalse(inventoryService.updateQuantityByProductCode("P001", -200));
		}
		
		@Test
		public void update_T004() {
			Mockito.when(inventoryDao.updateByQuantity("P099", 200)).thenReturn(0);
			
			assertFalse(inventoryService.updateQuantityByProductCode("P099", 200));
		}
	}

}
