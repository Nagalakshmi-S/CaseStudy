package com.catalog.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalog.bean.ProductCatalog;

@Repository
public interface ProductCatalogDao extends JpaRepository<ProductCatalog, Long> {

}
