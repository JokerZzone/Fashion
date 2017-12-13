package com.lanou.contorller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

	@RequestMapping("/find")
	public void name(int id) {
		categoryService.addCatData(id);
	}
	
	@RequestMapping("/select")
	@ResponseBody
	public String name1(int c) {
		return categoryService.selectCat(c);
	}
	
	@RequestMapping(value="/findOne")
	@ResponseBody
	public List<Map<String, Object>> showOne(){
		List<Map<String, Object>> caList = categoryService.selectDesc();
		return caList;
	}

	@RequestMapping("/show")
	@ResponseBody
	public List<Category> findOne() {
		List<Category> categories = categoryService.findOne();
		return categories;
	}
	
	@RequestMapping("/findTwo")
	@ResponseBody
	public String findTwo(@RequestParam("id") int catId) {
		return categoryService.selectCat(catId);
	}
	
	//卖家
	//商品分类
	@RequestMapping("/goodsCategory")
	@ResponseBody
	public Map<String, Object> findGoodsCategory(int pageId) {
		Map<String, Object> maps = new HashMap<>();
		List<Category> category = categoryService.findCategory(pageId);
		int total = categoryService.categoryTotal();
		int page = (int)Math.ceil((double)total/40);
		System.out.println(page);
		maps.put("total", total);
		maps.put("pageId", pageId);
		maps.put("page", page);
		maps.put("category", category);
		return maps;
	}
	
	//添加分类
	@RequestMapping("/addCategory")
	@ResponseBody
	public boolean addCategory(Category category) {
		boolean result = categoryService.addGoodCategory(category);
		return result;
	}
	
	//修改分类
	@RequestMapping("/updateCategory")
	@ResponseBody
	public boolean updateGoodsCategory(Category category) {
		Boolean result = categoryService.updateGoodCategory(category);
		return result;
	}
	
	//查看当前分类
	@RequestMapping("/oneCategory")
	@ResponseBody
	public Category findOneCategory(int catId) {
		Category category = categoryService.findOneCategory(catId);
		return category;
	}
	
	@InitBinder("category")
	public void initUser(WebDataBinder wBinder) {
		wBinder.setFieldDefaultPrefix("category.");
	}

}