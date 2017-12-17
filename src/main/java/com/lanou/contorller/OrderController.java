package com.lanou.contorller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Orders;
import com.lanou.entity.User;
import com.lanou.service.OrderService;
import com.lanou.util.Page;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("findOrderByUId")
	@ResponseBody
	public Map<String, Object> findOrderByUId(
			HttpSession session,
			int nowPage,
			@RequestParam(value="status",required=false,defaultValue="1") int status,
			@RequestParam(value="times",required=false,defaultValue="1") int times
			
		) {
		User user = (User) session.getAttribute("user");
		Page page = new Page(orderService.findOrderCountByUId(user.getuId(), status, times),nowPage);
		List<Orders> orders = orderService.findOrderByUId(user.getuId(),page.getStartPos(),page.getPageSize(),status,times);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("orders", orders);
		map.put("page", page);
		System.out.println(page);
		return map;
	}
	
	@RequestMapping("addOrder")
	public void addOrder(HttpSession session,int address_id,double money) {
		User user = (User) session.getAttribute("user");
		
		orderService.addOrder(user.getuId(),new Date(),address_id,money);
	}
	
	
//	@InitBinder("orders")
//	public void initOrders(WebDataBinder webDataBinder) {
//		webDataBinder.setFieldDefaultPrefix("orders");
//	}
}
