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
				for (Cart cart : carts) {
					if (cart.getGoodsId() == goods[i]) {
						int temp = cart.getGoodsNumber();
						temp += num[i];
						cart.setGoodsNumber(temp);
						cartMapper.updateCart(cart);
					}else {
						int goodsId = goods[i];
						int goodsNumber = num[i];
						Goods good = goodsMapper.findGoods(goodsId);
						String goodsName = good.getGoodsName();
						double shopPrice = good.getShopPrice();
						Cart nowCart = new Cart(userId,sessionId,goodsId,goodsName,shopPrice,goodsNumber);
						cartMapper.addCart(nowCart);
					}
				}
			}
		}else {
			for (int i = 0; i < goods.length; i++) {
				int goodsId = goods[i];
				int goodsNumber = num[i];
				Goods good = goodsMapper.findGoods(goodsId);
				String goodsName = good.getGoodsName();
				double shopPrice = good.getShopPrice();
				Cart nowCart = new Cart(userId,sessionId,goodsId,goodsName,shopPrice,goodsNumber);
				cartMapper.addCart(nowCart);
			}
		}
	}
	
	
	public List<Cart> showCart(int userId) {
		
		return cartMapper.selectByUserId(userId);
	}

}
