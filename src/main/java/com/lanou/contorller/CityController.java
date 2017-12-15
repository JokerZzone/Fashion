package com.lanou.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.City;
import com.lanou.service.CityService;

@Controller
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityService cityService;
	
	@RequestMapping("/province")
	@ResponseBody
	public List<City> province(@RequestParam("id") int parentId){
 
		return cityService.findProvince(parentId);
	}

	@RequestMapping("/city")
	@ResponseBody
	public List<City> city(@RequestParam("id") int cityId){
		
		return cityService.findCity(cityId);
	}
	
	
}
