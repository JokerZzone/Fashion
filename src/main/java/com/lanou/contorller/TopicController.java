package com.lanou.contorller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Topic;
import com.lanou.service.TopicService;
import com.lanou.util.PropertyConfigurer;

@Controller
@RequestMapping("/topic")
public class TopicController {

	@Autowired
	private TopicService service;
	
	@Autowired
	private PropertyConfigurer prop;
	
	@RequestMapping("/showTopic")
	@ResponseBody
	public List<Topic> showTopic() throws Exception {
		List<Topic> topics = service.showTopic();
		return topics;
	}
	
	@RequestMapping("/addTopic")
	public void addTopic() {
		int a = service.addTopic();
		System.out.println(a);
	}
}
