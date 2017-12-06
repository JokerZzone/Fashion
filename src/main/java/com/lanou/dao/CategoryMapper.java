package com.lanou.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lanou.entity.Category;

@Repository
public interface CategoryMapper {
	
	//wz
	public Category findByCatId(int catId);
	
	public List<Category> findByParentId(int parentId);
	
	//xy
	public List<Category> findSimpleFatherCategory();
	
	public List<Category> selectCategoryChildrenByParentId(Integer parentId);
	
}
