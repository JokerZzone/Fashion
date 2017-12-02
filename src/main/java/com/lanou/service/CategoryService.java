package com.lanou.service;

import java.util.List;

import com.lanou.entity.Category;

public interface CategoryService {
	
	public Category selectByPrimaryKey(Integer primaryKey);
	public List<Category> selectCategoryChildrenByParentId(Integer parentId);
//	展示一级分类
	public List<Category> showFatherCategory();
	
//  展示所有信息
	public List<Category> findAll(Integer parentId);  
}
