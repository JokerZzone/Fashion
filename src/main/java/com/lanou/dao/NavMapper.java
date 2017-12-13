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
	
	//xy
	//6.查看自定义导航栏
	public List<Nav> lookNav();
	
	//添加自定义导航栏
	public boolean addNav(Nav nav);
	
	//修改导航栏
	public boolean updateNav(Nav nav);
	
}
