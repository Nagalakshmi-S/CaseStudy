package com.catalog.service;

import java.util.List;
import java.util.Optional;

import com.catalog.bean.Product;
import com.catalog.bean.ProductList;

public interface ProductCatalogService {

	ProductList listAllProducts();
	Optional<Product> getProductByCode(String code);
}
