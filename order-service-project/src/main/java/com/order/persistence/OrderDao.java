package com.order.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.bean.Order;

public interface OrderDao extends JpaRepository<Order, Long> {

}
