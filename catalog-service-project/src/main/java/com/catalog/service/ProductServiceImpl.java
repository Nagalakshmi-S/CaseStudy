package com.catalog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalog.bean.Product;
import com.catalog.bean.ProductList;
import com.catalog.persistence.ProductCatalogDao;

@Service
public class ProductServiceImpl implements ProductCatalogService {

	@Autowired
	private ProductCatalogDao productCatalogDao;
	@Override
	public ProductList listAllProducts() {
		return new ProductList(productCatalogDao.findAll());
	}

	@Override
	public Optional<Product> getProductByCode(String code) {
		List<Product> prod=productCatalogDao.findByCode(code);
		if(prod.isEmpty()) {
			return Optional.empty();
		}
		return Optional.ofNullable(prod.get(0));
	}

}
