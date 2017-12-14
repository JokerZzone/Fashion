package com.lanou.contorller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Nav;
import com.lanou.entity.Topic;
import com.lanou.service.CategoryService;
import com.lanou.service.NavService;
import com.lanou.service.TopicService;

@Controller
@RequestMapping("/merge")
public class MergeController {

	@Autowired
	private NavService navService;
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/1")
	@ResponseBody
	public Map<String, Object> first() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Nav> navs = navService.showAll();
		List<Map<String, Object>> caList = categoryService.selectDesc();
		map.put("nav", navs);
		map.put("category", caList);
		return map;
	}
	
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Object> second() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Topic> topics = new ArrayList<Topic>();
		for (int i = 1; i < 4; i++) {
			topics.add(topicService.showTopic(i));
		}
		map.put("topic", topics);
		return map;
	}
	
}
