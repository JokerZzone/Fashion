package com.lanou.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lanou.entity.Nav;

@Repository
public interface NavMapper {
	
	//wz
	public List<Nav> selectAll();
	
	public Nav selectCatData(int navId);
	
	public int addCatData(String json, int navId);
	
}
