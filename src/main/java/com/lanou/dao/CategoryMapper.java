package com.lanou.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lanou.entity.Category;
import com.lanou.entity.Nav;

@Repository
public interface CategoryMapper {
	
	//wz
	public Nav selectCatData(int navId);
	
	public Category findByCatId(int catId);
	
	public List<Category> findByParentId(int parentId);
	
	public int addCatData(String json, int navId);
	
	
}
