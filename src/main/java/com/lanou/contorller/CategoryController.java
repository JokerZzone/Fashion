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
	
//	@RequestMapping(value="/findCategoryAndChild.do")
//	@ResponseBody
//	public Map<String, Object> findCategoryAndChild(Integer primaryKey) {
//		Category category = categoryService.selectByPrimaryKey(primaryKey);
//		System.out.println(primaryKey);
//		System.out.println(category);
//		if(category == null) {
//			return null;
//		}
//		category.setCategories(findChildCategory(category, primaryKey));
//		Map<String, Object> maps =new HashMap<String, Object>();
//		maps.put("category", category);
//		return maps;
//	}
	
	@RequestMapping(value="/findFatherAndChild.do")
	@ResponseBody
	public List<Category> findFatherAndChild() {
		List<Category>  category = categoryService.showFatherCategory();
		List<Category> category2 = new ArrayList<Category>();
		if(category.size()==0) {
			return null;
		}else {
			for(int i=1;i<category.size();i++) {
				Category categories = new Category();
				categories = category.get(i);
				categories.setCategories(findChildCategory(categories, i));
				List<Category> category3 = new ArrayList<Category>();
				category3.add(categories);
				category2.addAll(category3);
			}
		}
		return category2;
	}
	public List<Category> findChildCategory(Category category,Integer parentId){
		List<Category> caList = categoryService.selectCategoryChildrenByParentId(parentId);
		for (Category category2 : caList) {
			category2.setCategories(findChildCategory(category, category2.getCatId()));
		}	
	return caList;
  } 
	
	@RequestMapping("/findFatherCategory.do")
	@ResponseBody
	public  Map<String, Object> showFatherCategory() {
		List<Category> caList = categoryService.showFatherCategory();
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("caList", caList);
		return maps;
	}
}