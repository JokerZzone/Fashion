package com.lanou.service.impl;

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
		Cart cart = cartMapper.selectByUserId(userId);
		int parentId = 0;
		if (cart == null) {
			if (cartMapper.selectMax() == null) {
				parentId = 0;
			}else {
				parentId = cartMapper.selectMax();
			}
		}else {
			parentId = cart.getParentId();
		}
		for (int i = 0; i < goods.length; i++) {
			int goodsId = goods[i];
			int goodsNumber = num[i];
			Goods good = goodsMapper.findGoods(goodsId);
			String goodsName = good.getGoodsName();
			double shopPrice = good.getShopPrice();
			Cart nowCart = new Cart(userId,sessionId,goodsId,parentId,goodsName,shopPrice,goodsNumber);
			cartMapper.addCart(nowCart);
		}
	}

}
