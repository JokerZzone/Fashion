package com.lanou.service;

import java.util.List;
import java.util.Map;

import com.lanou.entity.Category;

public interface CategoryService {
	
	public List<Category> findFatherCategory();
	
	public Category selectByPrimaryKey(Integer primaryKey);
	
	public List<Category> selectCategoryChildrenByParentId(Integer parentId);
	
	public List<Map<String, Object>> selectDesc(Integer parentId);
	
	public List<Category> findChildCategory(Category category,Integer parentId);
	
	
	
}
