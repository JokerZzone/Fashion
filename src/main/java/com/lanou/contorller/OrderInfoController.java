package com.lanou.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Order;
import com.lanou.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderInfoController {
	
	private OrderService orderService;
	
	@RequestMapping("/addOrder")
	public void addOrders(@RequestParam("goods[]") int[] goods, @RequestParam("num[]") int[] num, HttpServletRequest request) {
		orderService.addOrder(goods, num, request);
	}

	@RequestMapping("/showOrder")
	@ResponseBody
	public List<Order> showOrder(HttpServletRequest request) {
		
		
		
		return null;
	}
	
}
