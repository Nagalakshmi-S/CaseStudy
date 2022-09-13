package com.catalog.service;

import java.util.List;
import java.util.Optional;

import com.catalog.bean.ProductCatalog;

public interface ProductCatalogService {

	List<ProductCatalog> listAllProducts();
	Optional<ProductCatalog> getProductByCode(String code);
}
