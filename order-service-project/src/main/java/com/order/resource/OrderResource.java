package com.order.resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.bean.Order;

@RestController
public class OrderResource {
	
	@PostMapping (path = "/orders",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean saveOrder(Order order) {
		return false;}
	
	@GetMapping(path = "/orders/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Order findOrderById (long id) {
		return null;}



}
