package com.lanou.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.dao.CartMapper;
import com.lanou.dao.GoodsMapper;
import com.lanou.entity.Cart;
import com.lanou.entity.Goods;
import com.lanou.entity.User;
import com.lanou.service.CartService;

@Service("cartService")
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	public void saveCart(int[] goods, int[] num, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int userId = user.getuId();
		String sessionId = session.getId();
		List<Cart> carts = cartMapper.selectByUserId(userId);
		if (carts.size() != 0) {
			for (int i = 0; i < goods.length; i++) {
				boolean isHas = true;
				for (Cart cart : carts) {
					if (cart.getGoodsId() == goods[i]) {
						cart.setGoodsNumber(cart.getGoodsNumber()+num[i]);
						cartMapper.updateCart(cart);
						isHas = false;
					}
				}
				if (isHas) {
					Goods good = goodsMapper.findGoods(goods[i]);
					Cart nowCart = new Cart(userId,sessionId,goods[i],good.getGoodsName(),good.getShopPrice(),num[i]);
					cartMapper.addCart(nowCart);					
				}
			}
		}else {
			for (int i = 0; i < goods.length; i++) {
				Goods good = goodsMapper.findGoods(goods[i]);
				Cart nowCart = new Cart(userId,sessionId,goods[i],good.getGoodsName(),good.getShopPrice(),num[i]);
				cartMapper.addCart(nowCart);
			}
		}
	}
	
	
	public List<Cart> showCart(int userId) {
		
		return cartMapper.selectByUserId(userId);
	}


	@Override
	public void deleteAllCartByUId(int user_id) {
		// TODO Auto-generated method stub
		cartMapper.deleteAllCartByUId(user_id);
	}


	@Override
	public void deleteCartById(int rec_id) {
		// TODO Auto-generated method stub
		cartMapper.deleteCartById(rec_id);
	}


	@Override
	public void updateGoodsNum(int rec_id, int number) {
		// TODO Auto-generated method stub
		cartMapper.updateGoodsNum(rec_id, number);
	}


}
