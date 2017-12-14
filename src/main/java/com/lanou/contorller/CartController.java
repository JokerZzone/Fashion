package com.lanou.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Cart;
import com.lanou.entity.User;
import com.lanou.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping("/cart")
	public void getCart(@RequestParam("goods[]") int[] goods, @RequestParam("num[]") int[] num, HttpServletRequest request) {
		cartService.saveCart(goods, num, request);
	}
<<<<<<< HEAD
	
	@RequestMapping("/showCart")
	@ResponseBody
	public List<Cart> showCart(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		return cartService.showCart(user.getuId());
	}
	
=======
>>>>>>> origin/12.12
}
