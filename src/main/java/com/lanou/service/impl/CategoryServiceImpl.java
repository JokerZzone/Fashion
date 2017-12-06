package com.lanou.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanou.dao.CategoryMapper;
import com.lanou.dao.GoodsMapper;
import com.lanou.entity.Category;
import com.lanou.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Transactional
	public List<Category> findFatherCategory() {
		// TODO Auto-generated method stub
		return categoryMapper.findFatherCategory();
	}
	
//	@Transactional
//	public List<Category> findFatherCategory() {
//		// TODO Auto-generated method stub
//		List<Category> caList = categoryMapper.findFatherCategory();
//		List<Category> caList3 = new ArrayList<Category>();
//		int primaryKey = 0;
//		for(int i=0;i<caList.size();i++) {
//			primaryKey = caList.get(i).getCatId();
//			Category category = categoryMapper.selectByPrimaryKey(primaryKey);
//			if(category == null) {
//				return null;
//			}
//			category.setCategories(findChildCategory(category, primaryKey));
//			List<Category> caList2 = new ArrayList<Category>();
//			caList2.add(category);
//			caList3.addAll(caList2);
//		}
//		return caList3;
//	}
	
	@Transactional
	public Category selectByPrimaryKey(Integer primaryKey) {
		// TODO Auto-generated method stub
		return categoryMapper.selectByPrimaryKey(primaryKey);
	}
	
	@Transactional
	public List<Map<String, Object>> selectDesc(Integer parentId) {
		List<Category> fatherList = categoryMapper.findSimpleFatherCategory();
		List<Map<String, Object>> one = new ArrayList<Map<String,Object>>();
		for(int i=0;i<fatherList.size();i++) {
			List<Map<String, Object>> two = new ArrayList<Map<String,Object>>();
			parentId = fatherList.get(i).getCatId();
			List<Category> childList = categoryMapper.selectCategoryChildrenByParentId(parentId);
			Map<String, Object> onemap = new HashMap<String, Object>();
			for (int j = 0; j < childList.size(); j++) {
				String twoName = childList.get(j).getCatName();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("twoName", twoName);
				two.add(map);
			}
			onemap.put("firstCategoryId", i+1);
			onemap.put("firstCategory", fatherList.get(i).getCatName());
			onemap.put("SecondCategory", two);
			one.add(onemap);
		}
		return one;
	}
	
	@Transactional
	public List<Category> findChildCategory(Category category, Integer parentId) {
		// TODO Auto-generated method stub
		category = categoryMapper.selectByPrimaryKey(parentId);
		List<Category> caList = categoryMapper.selectCategoryChildrenByParentId(parentId);
		for (Category category2 : caList) {
			category2.setCategories(findChildCategory(category, category2.getCatId()));
		}	
		return caList;
	}

	public List<Category> selectCategoryChildrenByParentId(Integer parentId) {
		// TODO Auto-generated method stub
		return categoryMapper.selectCategoryChildrenByParentId(parentId);
	}

	
	
	

}
