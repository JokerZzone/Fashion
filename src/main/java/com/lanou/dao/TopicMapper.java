package com.lanou.dao;

import org.springframework.stereotype.Repository;
import com.lanou.entity.Topic;

@Repository
public interface TopicMapper {

	public Topic selectTopic(int topicId);
	
	public int addDataInfo(String json, int topicId);
	
}
