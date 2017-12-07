package com.lanou.contorller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String name1(@RequestParam("id") int catId) {
		return categoryService.selectCat(catId);
	}
	
	@RequestMapping(value="/show")
	@ResponseBody
	public List<Map<String, Object>> showOne(@RequestParam("id") Integer parentId){
		List<Map<String, Object>> caList = categoryService.selectDesc(parentId);
		return caList;
	}

}