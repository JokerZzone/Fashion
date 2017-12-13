package com.lanou.service;

import java.util.List;
import java.util.Map;

import com.lanou.entity.Category;

public interface CategoryService {
	
	//wz
	public void addCatData(int navId);
	
	public String selectCat(int catId);
	
	//xy
	public List<Map<String, Object>> selectDesc();
	
	public List<Category> findOne();
	
	//商品分类
	public List<Category> findCategory(int pageId);
	
	public int categoryTotal();
	
	//修改商品分类
	public boolean updateGoodCategory(Category category);
	
	//添加商品分类
	public boolean addGoodCategory(Category category);
	
	//根据前台返回的id获取商品信息
	public Category findOneCategory(int catId);

}
