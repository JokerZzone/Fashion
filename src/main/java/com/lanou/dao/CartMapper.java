package com.lanou.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lanou.entity.Cart;

@Repository
public interface CartMapper {

	public List<Cart> selectByUserId(int userId);
	
	public Cart selectByGoodsId(int goodsId);
	
	public Integer selectMax();
	
	public void addCart(Cart cart);
	
	public void updateCart(Cart cart);
	
	//清空购物车
	public void deleteAllCartByUId(int user_id);
	
	//购物车删除单条
	public void deleteCartById(int rec_id);
	
	public void updateGoodsNum(int rec_id,int number);
	
	public void updateOrder_id(int user_id,int order_id);
}
