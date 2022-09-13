package com.catalog.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.catalog.bean.ProductCatalog;

@Repository
public interface ProductCatalogDao extends JpaRepository<ProductCatalog, Long> {
	
	
	@Query(value="from productCatalog where code=:code")
	Optional<ProductCatalog> findByCode(String code);

}
