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

	@RequestMapping(value = "/findCategoryAndChild.do")
	@ResponseBody
	public List<Category> findCategoryAndChild(Integer primaryKey) {
		List<Category> caList = categoryService.showFatherCategory();
		List<Category> caList3 = new ArrayList<Category>();
		for (int i = 0; i < caList.size(); i++) {
			primaryKey = caList.get(i).getCatId();
			Category category = categoryService.selectByPrimaryKey(primaryKey);
			if (category == null) {
				return null;
			}
			category.setCategories(findChildCategory(category, primaryKey));
			List<Category> caList2 = new ArrayList<Category>();
			caList2.add(category);
			caList3.addAll(caList2);
		}
		return caList3;
	}

	public List<Category> findChildCategory(Category category, Integer parentId) {
		List<Category> caList = categoryService.selectCategoryChildrenByParentId(parentId);
		for (Category category2 : caList) {
			category2.setCategories(findChildCategory(category, category2.getCatId()));
		}
		return caList;
	}

	@RequestMapping("/findFatherCategory.do")
	@ResponseBody
	public List<Category> showFatherCategory() {
		List<Category> caList = categoryService.showFatherCategory();
		System.out.println(caList);
		return caList;
	}


}