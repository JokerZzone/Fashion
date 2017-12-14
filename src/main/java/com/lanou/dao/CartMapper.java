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
}
