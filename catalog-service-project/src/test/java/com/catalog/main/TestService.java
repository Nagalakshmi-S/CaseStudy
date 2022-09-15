package com.catalog.main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.catalog.bean.Product;
import com.catalog.bean.ProductList;
import com.catalog.persistence.ProductCatalogDao;
import com.catalog.service.ProductServiceImpl;

@SpringBootTest(classes=com.catalog.main.CatalogServiceProjectApplication.class)
@RunWith(MockitoJUnitRunner.class)
public class TestService {
	
	@Autowired
	@InjectMocks
	ProductServiceImpl productService;
	
	@Mock
	ProductCatalogDao productDao;
	
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
	class TestGetProductsList{
		@Test
		public void getProductsList_T01() {
			List<Product> productList=new ArrayList<>();
			productList.add(new Product(1,"P001","Product1","This is 1st product",778));
			productList.add(new Product(2,"P002","Product2","This is 2nd product",500));
			productList.add(new Product(3,"P003","Product3","This is 3rd product",1250));
			productList.add(new Product(4,"P004","Product4","This is 4th product",1300));
			
			Mockito.when(productDao.findAll()).thenReturn(productList);
			
			ProductList expected=new ProductList(productList);
			assertEquals(expected, productService.listAllProducts());
		}
		
		@Test
		public void getProductsList_T02() {
			List<Product> productList=new ArrayList<>();
			
			Mockito.when(productDao.findAll()).thenReturn(productList);
			
			ProductList expected=new ProductList(productList);
			assertEquals(expected, productService.listAllProducts());
		}
	}
	
	@Nested
	class TestGetProductByCode{
		@Test
		public void getProductByCode_T01() {
			List<Product> productList=new ArrayList<>();
			productList.add(new Product(1,"P001","Product1","This is 1st product",778));
			Mockito.when(productDao.findByCode("P001")).thenReturn(productList);
			
			Optional<Product> expected=Optional.ofNullable(productList.get(0));
			
			assertEquals(expected, productService.getProductByCode("P001"));
		}
		
		@Test
		public void getProductByCode_T02() {
			List<Product> productList=new ArrayList<>();
//			productList.add(new Product(1,"P001","Product1","This is 1st product",778));
			Mockito.when(productDao.findByCode("P099")).thenReturn(productList);
			
			Optional<Product> expected=Optional.empty();
			
			assertEquals(expected, productService.getProductByCode("P099"));
		}
	}
}
