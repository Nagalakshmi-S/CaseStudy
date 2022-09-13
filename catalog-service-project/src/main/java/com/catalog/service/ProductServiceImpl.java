package com.catalog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalog.bean.ProductCatalog;
import com.catalog.persistence.ProductCatalogDao;

@Service
public class ProductServiceImpl implements ProductCatalogService {

	@Autowired
	private ProductCatalogDao productCatalogDao;
	@Override
	public List<ProductCatalog> listAllProducts() {
		return null;
	}

	@Override
	public Optional<ProductCatalog> getProductByCode(String code) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
