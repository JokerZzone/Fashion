package com.lanou.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	
}
