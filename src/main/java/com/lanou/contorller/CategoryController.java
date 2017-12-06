package com.lanou.contorller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Category;
import com.lanou.service.CategoryService;

@Controller
@RequestMapping("/Category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;	
	
//	首页一级分类方法
	@RequestMapping(value="/findDesc.do")
	@ResponseBody
	public List<Map<String, Object>> findDesc(Integer parentId) {
		List<Map<String, Object>> categories = categoryService.selectDesc(parentId);
		return categories;
	}
	
	@RequestMapping(value="/findChild.do")
	@ResponseBody
	public List<Category> findChildCategory(Category category,Integer parentId) {
		List<Category> categories = categoryService.findChildCategory(category, parentId);
		return categories;
	}
	
			
}