package com.lanou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanou.dao.CategoryMapper;
import com.lanou.entity.Category;
import com.lanou.entity.Nav;
import com.lanou.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryMapper categoryMapper;

	// 首页的分类展示
	public String selectCat(int navId, int catId) {
		Category category = categoryMapper.findByCatId(catId);
		Nav nav = categoryMapper.selectCatData(navId);
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
	public void addCateData(int navId) {
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

}
