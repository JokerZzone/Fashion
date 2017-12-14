package com.lanou.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lanou.entity.Cart;

public interface CartService {

	public void saveCart(int[] goods, int[] num, HttpServletRequest request);
	
	public List<Cart> showCart(int userId);
}
