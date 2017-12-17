package com.lanou.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lanou.entity.Orders;

@Repository
public interface OrderMapper {

	public List<Orders> findOrderByUId(Map<String,Object> map);
	public int findOrderCountByUId(
			@Param("userId") int userId,
			@Param("status") int status,
			@Param("times") int times
		);
	
	public int addOrder(Map<String,Object> map);
}
