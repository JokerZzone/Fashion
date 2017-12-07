package com.lanou.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanou.dao.CategoryMapper;
import com.lanou.dao.NavMapper;
import com.lanou.entity.Category;
import com.lanou.entity.Nav;
import com.lanou.service.CategoryService; 

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Autowired
	private NavMapper navMapper;
	
	// 首页的分类展示
	public String selectCat(int catId) {
		Category category = categoryMapper.findByCatId(catId);
		//默认参数为1
		Nav nav = navMapper.selectCatData(1);
		String[] temp = nav.getCatData().split("#");
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].contains(category.getCatName())) {
				System.out.println(temp[i].split(category.getCatName() + ":")[1]);
				return temp[i].split(category.getCatName() + ":")[1];
			}
		}
		return null;
	}

	@Transactional
	public void addCatData(int navId) {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		for (int i = 1; i < 7; i++) {
			List<Category> categories = categoryMapper.findByParentId(i);
			Category category = categoryMapper.findByCatId(i);
			String str = null;
			try {
				str = mapper.writeValueAsString(categories);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (json == null) {
				json = category.getCatName() + ":" + str + "#";
			} else {
				json += category.getCatName() + ":" + str + "#";
			}
		}
	}

	/******************************************************************/
//	一级分类展示
	@Transactional
	public List<Map<String, Object>> selectDesc() {
		List<Category> fatherList = categoryMapper.findSimpleFatherCategory();
		List<Map<String, Object>> one = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < fatherList.size(); i++) {
			List<Map<String, Object>> two = new ArrayList<Map<String, Object>>();
			int catId = fatherList.get(i).getCatId();
			List<Category> childList = categoryMapper.selectCategoryChildrenByParentId(catId);
			Map<String, Object> onemap = new HashMap<String, Object>();
			for (int j = 0; j < childList.size(); j++) {
				String twoName = childList.get(j).getCatName();
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("secondId", childList.get(j).getCatId());
				map.put("secondName", twoName);
				two.add(map);
			}
			List<Map<String, Object>> three = new ArrayList<Map<String, Object>>();
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("firstId", i+1);
			map2.put("firstName",fatherList.get(i).getCatName());
			three.add(map2);
			onemap.put("firstCategory", three);
			onemap.put("Desc", two);
			one.add(onemap);
		}
		return one;
	}

	//展示一级分类
	public List<Category> findOne() {
		// TODO Auto-generated method stub
		return categoryMapper.findSimpleFatherCategory();
	}

}
