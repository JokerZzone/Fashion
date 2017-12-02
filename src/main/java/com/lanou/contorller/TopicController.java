package com.lanou.contorller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Topic;
import com.lanou.service.TopicService;

@Controller
@RequestMapping("/topic")
public class TopicController {

	@Autowired
	private TopicService service;
	
	@RequestMapping("/showTopic")
	@ResponseBody
	public Map<String, Topic> showTopic(@RequestParam("id") int topicId) throws Exception {
		Topic topic = service.showTopic(topicId);
		Map<String, Topic> map = new HashMap<String, Topic>();
		map.put("topic", topic);
		return map;
	}
	
	@RequestMapping("/addTopic")
	public void addTopic() {
		int a = service.addTopic();
		System.out.println(a);
	}
}
