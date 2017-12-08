package com.lanou.service;

import com.lanou.entity.Topic;

public interface TopicService {

	public Topic showTopic(int topicId, int type);
	
	public void addDataInfo(int topicId);
}
