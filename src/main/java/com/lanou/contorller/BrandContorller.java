package com.lanou.contorller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
=======
import org.springframework.web.bind.WebDataBinder;
>>>>>>> origin/12.12
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Brand;
import com.lanou.service.BrandService;

@Controller
@RequestMapping("/brand")
public class BrandContorller {

	@Autowired
	private BrandService brandService;
	
	//查看品牌库
	@RequestMapping(value="/findAllBrand",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Map<String, List<Brand>>> findAllBrand() {
		Map<String, List<Brand>> map1 = new HashMap<String, List<Brand>>();
		Map<String, List<Brand>> map2 = new HashMap<String, List<Brand>>();
		// 1是欧美  2日韩  3国产  推荐随便整四张图
		for (int i = 1; i <= 3; i++) {
			String braDesc = "" + i;
			List<Brand> brands = brandService.selectLikeDesc_Country(braDesc);
			map1.put(braDesc, brands);
		}
		//  字母A-Z
		for (int i = 65; i <= 90; i++) {
			String braDesc = "" + (char)i; 
			List<Brand> brands = brandService.selectLikeDesc_Letter(braDesc);
			map2.put(braDesc, brands);
		}
		Map<String, Map<String, List<Brand>>> map = new HashMap<String, Map<String,List<Brand>>>();
		map.put("countory", map1);
		map.put("letter", map2);
		return map;
	}
	
<<<<<<< HEAD

=======
	//卖家
	//四.商品品牌
	//1.查看商品品牌
	@RequestMapping("/allBrands")
	@ResponseBody
	public Map<String, Object> findAllBrands(@RequestParam("pageId")int pageId, @RequestParam("pageNumber")int pageNumber)	{
		Map<String, Object> maps = brandService.findAllBrands(pageId, pageNumber);
		return maps;
	}
	
	//2.模糊查询品牌
	@RequestMapping("/likeBrands")
	@ResponseBody
	public Map<String, Object> findLikeBrands(@RequestParam("name")String name,@RequestParam("pageId")int pageId, @RequestParam("pageNumber")int pageNumber)	{
		Map<String, Object> maps = brandService.findLikeBrands(name, pageId, pageNumber);
		return maps;
	}
	
	//3.添加品牌
	@RequestMapping("/addBrand")
	@ResponseBody
	public boolean addBrand(Brand brand)	{
		boolean result = brandService.addBrand(brand);
		return result;
	}
	
	//4.修改品牌
	@RequestMapping("/updateBrand")
	@ResponseBody
	public boolean updateBrand(Brand brand)	{
		boolean result = brandService.updateBrand(brand);
		return result;
	}
	
	//5.删除品牌
	@RequestMapping("/deleteBrand")
	@ResponseBody
	public boolean deleteBrand(int brandId)	{
		boolean result = brandService.deleteBrand(brandId);
		return result;
	}
	
	@InitBinder("brand")
	public void initUser(WebDataBinder wBinder) {
		wBinder.setFieldDefaultPrefix("brand.");
	}
>>>>>>> origin/12.12
}
