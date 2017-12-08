package com.lanou.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.dao.AdMapper;
import com.lanou.dao.TopicMapper;
import com.lanou.entity.Ad;
import com.lanou.entity.Topic;

@Controller
@RequestMapping("/test")
public class Test02 {
	
	@Autowired
	private TopicMapper mappper;
	
	@RequestMapping("/test")
	@ResponseBody
	public Topic name(int a) {
		
		return mappper.selectTopic(a);
		
	}
	
}
