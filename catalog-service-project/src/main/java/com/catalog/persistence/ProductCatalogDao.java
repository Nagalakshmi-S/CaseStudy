package com.catalog.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.catalog.bean.ProductCatalog;

@Repository
public interface ProductCatalogDao extends JpaRepository<ProductCatalog, Integer> {
	
	
	@Query(value="from ProductCatalog where code=:productCode")
	Optional<ProductCatalog> findByProductCode(String productCode);

}
