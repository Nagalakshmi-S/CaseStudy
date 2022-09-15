package com.catalog.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalog.bean.Product;

@Repository
public interface ProductCatalogDao extends JpaRepository<Product, Integer> {
	
	List<Product> findByCode(String productCode);

}
