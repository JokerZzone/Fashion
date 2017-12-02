package com.lanou.service;

import java.util.List;

import com.lanou.entity.Topic;

public interface TopicService {

	public List<Topic> showTopic();
	
	public int addTopic();
}
