package com.lanou.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lanou.entity.Cart;

public interface CartService {

	public void saveCart(int[] goods, int[] num, HttpServletRequest request);

	//查看购物车
	public List<Cart> showCart(int userId);
	
	// 清空购物车
	public void deleteAllCartByUId(int user_id);

	// 购物车删除单条
	public void deleteCartById(int rec_id);
	
	public void updateGoodsNum(int rec_id,int number);
	
}
