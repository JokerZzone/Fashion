package com.lanou.contorller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
}
