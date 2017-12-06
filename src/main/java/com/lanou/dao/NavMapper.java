package com.lanou.dao;

import org.springframework.stereotype.Repository;

import com.lanou.entity.Nav;

@Repository
public interface NavMapper {
	
	//wz
	public Nav selectCatData(int navId);
	
	public int addCatData(String json, int navId);
	
}
