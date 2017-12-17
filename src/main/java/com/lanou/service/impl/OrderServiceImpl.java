package com.lanou.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.dao.CartMapper;
import com.lanou.dao.OrderMapper;
import com.lanou.entity.Orders;
import com.lanou.service.OrderService;
import com.lanou.util.Page;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private CartMapper cartMapper;

	@Override
	public List<Orders> findOrderByUId(int userId,int startPos,int pageSize,int status,int times) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("startPos", startPos);
		map.put("pageSize", pageSize);
		map.put("status", status);
		map.put("times", times);			
		
		return orderMapper.findOrderByUId(map);
	}
	@Override
	public int findOrderCountByUId(int userId,int status,int times) {
		// TODO Auto-generated method stub
		return orderMapper.findOrderCountByUId(userId,status,times);
	}

	@Override
	public void addOrder(int user_id,Date beginTime,int address_id,double money) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user_id", user_id);
		map.put("beginTime", beginTime);
		map.put("address_id", address_id);
		map.put("money", money);
		orderMapper.addOrder(map);
		cartMapper.updateOrder_id(user_id, (int)map.get("order_id"));
		
	}

	
	
	

	


	
}
