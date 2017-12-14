package com.lanou.contorller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Order;

@Controller
@RequestMapping("/order")
public class OrderController {

	@RequestMapping("/showOrder")
	@ResponseBody
	public List<Order> showOrder(HttpServletRequest request) {
		
		
		
		return null;
	}
	
}
