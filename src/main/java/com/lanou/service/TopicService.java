package com.lanou.service;

import java.util.List;

import com.lanou.entity.Goods;
import com.lanou.entity.Topic;

public interface TopicService {

	public Topic showTopic(int topicId);
	
	public List<Goods> addTopic();
}
