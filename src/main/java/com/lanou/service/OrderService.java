package com.lanou.service;

import javax.servlet.http.HttpServletRequest;

import com.lanou.entity.Order;

public interface OrderService {
	
	public void addOrder(int[] goods, int[] num, HttpServletRequest request);

	public Order showOrder(int userId);
}
