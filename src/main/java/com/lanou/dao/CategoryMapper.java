package com.lanou.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lanou.entity.Category;

@Repository
public interface CategoryMapper {
	
//	无限极查询
	public Category selectByPrimaryKey(Integer primaryKey);
	public List<Category> selectCategoryChildrenByParentId(Integer parentId);
//	查找一级分类 parentId = 0
	public List<Category> findFatherCategory();
  
//  根据一级分类查找二级分类
	public List<Category> findSecondCategory(Integer parentId);
}
