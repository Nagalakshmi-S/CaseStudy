package com.inventory.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.bean.InventoryItem;

@Repository
public interface InventoryItemDao extends JpaRepository<InventoryItem,Long> {

	InventoryItem findByProductCode(String code);

	@Modifying
	@Transactional
	@Query(value="update InventoryItem set availableQuantity=:availableQuantity where productCode=:code")
	int updateByQuantity(String code, int availableQuantity);

}
