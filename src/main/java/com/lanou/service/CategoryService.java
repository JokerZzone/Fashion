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
	
	public List<Category> showOne();

	public List<Category> showTwo(Integer catId);
	

}
