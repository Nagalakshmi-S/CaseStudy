package com.order.service;

import com.order.bean.Order;

public interface OrderService {
	
	Order saveOrder(Order order);

	Order findOrderById(long id);
}
