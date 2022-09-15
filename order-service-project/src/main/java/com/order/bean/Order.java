package com.order.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    private long id;
    private String customerEmail;
    private String customerAddress;
    private List<OrderItem> items;

}
