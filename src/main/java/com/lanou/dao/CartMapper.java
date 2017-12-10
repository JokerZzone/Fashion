package com.lanou.dao;

import org.springframework.stereotype.Repository;

import com.lanou.entity.Cart;

@Repository
public interface CartMapper {

	public Cart selectByUserId(int userId);
	
	public Integer selectMax();
	
	public void addCart(Cart cart);
}
