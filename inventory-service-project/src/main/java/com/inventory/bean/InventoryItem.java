package com.inventory.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class InventoryItem {
	@Id
    private Long id; 
    private String productCode;
    private int availableQuantity ;
}



