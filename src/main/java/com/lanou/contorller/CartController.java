package com.lanou.contorller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Address;
import com.lanou.entity.Cart;
import com.lanou.entity.User;
import com.lanou.service.AddressService;
import com.lanou.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private AddressService addressService;
	
	@RequestMapping("/cart")
	public void getCart(@RequestParam("goods[]") int[] goods, @RequestParam("num[]") int[] num, HttpServletRequest request) {
		cartService.saveCart(goods, num, request);
	}
	
	@RequestMapping("/showCart")
	@ResponseBody
	public List<Cart> showCart(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		return cartService.showCart(user.getuId());
	}
	
	//清空购物车
	@RequestMapping("/deleteAllCartByUId")
	public void deleteAllCartByUId(HttpSession session) {
		User user = (User) session.getAttribute("user");
		cartService.deleteAllCartByUId(user.getuId());
	}
	
	//删除单个
	@RequestMapping("/deleteCartById")
	public void deleteCartById(int rec_id) {
		cartService.deleteCartById(rec_id);
	}
	
	//修改商品数量
	@RequestMapping("/updateGoodsNum")
	public void updateGoodsNum(int rec_id,int number) {
		cartService.updateGoodsNum(rec_id, number);
	}
	
	//去结算
	@RequestMapping("/toSettle")
	@ResponseBody
	public Map<String, Object> toSettle(HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Address> addresses = addressService.selectAll(user.getuId());
		List<Cart> carts = cartService.showCart(user.getuId());
		Map<String, Object> map = new HashMap<>();
		map.put("addresses", addresses);
		map.put("carts", carts);
		return map;
	}
}
