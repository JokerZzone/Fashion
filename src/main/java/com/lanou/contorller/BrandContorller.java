package com.lanou.contorller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Brand;
import com.lanou.service.BrandService;

@Controller
@RequestMapping("/brand")
public class BrandContorller {

	@Autowired
	private BrandService brandService;
	
	@RequestMapping(value="/findAllBrand.do",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, List<Brand>> findAllBrand() {
		
		Map<String, List<Brand>> map = new HashMap<String, List<Brand>>();
		// 1是欧美  2日韩  3国产  推荐随便整四张图
		for (int i = 1; i <= 3; i++) {
			String braDesc = "" + i;
			List<Brand> brands = brandService.selectLikeDesc_Country(braDesc);
			map.put(braDesc, brands);
		}
		//  字母A-Z
		for (int i = 65; i <= 90; i++) {
			String braDesc = "" + (char)i; 
			List<Brand> brands = brandService.selectLikeDesc_Letter(braDesc);
			map.put(braDesc, brands);
		}
		return map;
	}
	
}
