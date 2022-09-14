package com.catalog.bean;

import java.util.List;

import javax.persistence.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductList {

	private List<Product> productCatalogList;
}
