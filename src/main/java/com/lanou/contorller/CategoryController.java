package com.lanou.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/find")
	public void name(int id) {
		categoryService.addCateData(id);
	}
	
	@RequestMapping("/select")
	@ResponseBody
	public String name1(int na, int c) {
		return categoryService.selectCat(na, c);
	}

}