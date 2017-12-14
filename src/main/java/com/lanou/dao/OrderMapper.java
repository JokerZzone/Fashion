package com.lanou.dao;

import org.springframework.stereotype.Repository;

import com.lanou.entity.Order;

@Repository
public interface OrderMapper {

	public Order findOrderById(int userId);
	
}
