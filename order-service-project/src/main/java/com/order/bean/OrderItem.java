package com.order.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderItem {
	@Id
    private long id;
    private String productId;
    private int quantity;
    private double productPrice;
}

