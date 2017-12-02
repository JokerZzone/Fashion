package com.lanou.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Topic showTopic(int topicId, Model model) throws Exception {
		Topic topic = service.showTopic(topicId);
		model.addAttribute("topic", topic);
		return topic;
	}
	
	@RequestMapping("/addTopic")
	public void addTopic() {
		int a = service.addTopic();
		System.out.println(a);
	}
}
