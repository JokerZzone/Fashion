package com.lanou.contorller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Category;
import com.lanou.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/add")
	public void name(int id) {
		
		categoryService.addCatData(id);
	}
	
	//首页
	@RequestMapping(value="/findOne")
	@ResponseBody
	public List<Map<String, Object>> showOne(){
		List<Map<String, Object>> caList = categoryService.selectDesc();
		return caList;
	}
	
	@RequestMapping("/findTwo")
	@ResponseBody
	public List<Category> findTwo(@RequestParam("id") Integer parentId) {
		List<Category> categories = categoryService.findTwo(parentId);
		return categories;
	}
	
	//超值小样
	@RequestMapping("/show")
	@ResponseBody
	public List<Category> findOne() {
		List<Category> categories = categoryService.findOne();
		return categories;
	}
	
	//wz
	@RequestMapping("/select")
	@ResponseBody
	public String name1(@RequestParam("id") int catId) {
		
		return categoryService.selectCat(catId);
	}
}