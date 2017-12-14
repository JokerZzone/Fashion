package com.lanou.service;

import java.util.List;

import com.lanou.entity.Nav;

public interface NavService {

	public List<Nav> showAll();
	
	//xy	
	//展示导航栏
	public List<Nav> showNav();
	
	//添加导航栏
	public boolean addNav(Nav nav);
	
	//修改导航栏
	public boolean updateNav(Nav nav);
	 
}
