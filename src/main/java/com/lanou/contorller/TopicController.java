package com.lanou.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Topic;
import com.lanou.service.TopicService;

@Controller
@RequestMapping("/topic")
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/showTopic")
	@ResponseBody
	public Topic showTopic(@RequestParam("id") int topicId, int type) throws Exception {
		
		return topicService.showTopic(topicId, type);
	}
	
	
	
}
