package com.catalog.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.bean.Product;
import com.catalog.bean.ProductList;
import com.catalog.service.ProductCatalogService;
import com.catalog.service.ProductServiceImpl;

@RestController
public class ProductResource {

	@Autowired
	private ProductServiceImpl productService;
	
	@GetMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductList listAllProducts(){
		return productService.listAllProducts();
	}
	
	@GetMapping(path = "/products/code/{productCode}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Product> getProductByCode(@PathVariable("productCode") String productCode){
		return productService.getProductByCode(productCode);
	}

}
