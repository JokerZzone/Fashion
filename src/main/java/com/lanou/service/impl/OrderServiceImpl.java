package com.lanou.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.entity.Cart;
import com.lanou.entity.Order;
import com.lanou.service.CartService;
import com.lanou.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	@Override
	public Order showOrder(int userId) {
		List<Cart> carts = cartService.showCart(userId);
		
		
		return null;
	}

	@Override
	public void addOrder(int[] goods, int[] num, HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	


	
}
