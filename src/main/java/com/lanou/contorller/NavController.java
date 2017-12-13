package com.lanou.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Nav;
import com.lanou.service.NavService;

@Controller
@RequestMapping("/nav")
public class NavController {

	@Autowired
	private NavService navService;
	
	
	@RequestMapping("showAllNavs")
	@ResponseBody
	public List<Nav> showAllNavs() {
		
		return navService.showAll();
	}
	
	//xy
	//展示导航栏
	@RequestMapping("/showNavs")
	@ResponseBody
	public List<Nav> showNavs() {
		return navService.showNav();
	}
	
	//添加导航栏
	@RequestMapping("/addNavs")
	@ResponseBody
	public boolean addNavs(Nav nav) {
		boolean result = navService.addNav(nav);
		return result;
	}
	
	//修改导航栏
	@RequestMapping("/updateNavs")
	@ResponseBody
	public boolean updateNavs(Nav nav) {
		boolean result = navService.updateNav(nav);
		return result;
	}
	
	@InitBinder("nav")
	public void initUser(WebDataBinder wBinder) {
		wBinder.setFieldDefaultPrefix("nav.");
	}
	
}
