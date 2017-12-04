package com.lanou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanou.dao.CategoryMapper; 
import com.lanou.entity.Category;
import com.lanou.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Transactional
	public Category selectByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return categoryMapper.selectByPrimaryKey(primaryKey);
	}
	
	@Transactional
	public List<Category> selectCategoryChildrenByParentId(Integer parentId) {
		// TODO Auto-generated method stub
		return categoryMapper.selectCategoryChildrenByParentId(parentId);
	}

	public List<Category> showFatherCategory() {
		// TODO Auto-generated method stub
		return categoryMapper.findFatherCategory();
	}

	public List<Category> findSecondCategory(Integer parentId) {
		// TODO Auto-generated method stub
		return categoryMapper.findSecondCategory(parentId);
	}

	

}
