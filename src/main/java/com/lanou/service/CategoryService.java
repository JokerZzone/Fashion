package com.lanou.service;

import java.util.List;

import com.lanou.entity.Category;

public interface CategoryService {
	
	public Category selectByPrimaryKey(Integer primaryKey);
	public List<Category> selectCategoryChildrenByParentId(Integer parentId);
	
//	展示一级分类
	public List<Category> showFatherCategory();
	
	public List<Category> findSecondCategory(Integer parentId);  
	
	
	
}
