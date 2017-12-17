package com.lanou.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lanou.entity.Orders;

public interface OrderService {
	
	public List<Orders> findOrderByUId(int userId,int startPos,int pageSize,int status,int times);
	public int findOrderCountByUId(int userId,int status,int times);
	
	public void addOrder(int user_id,Date beginTime,int address_id,double noney);
}
