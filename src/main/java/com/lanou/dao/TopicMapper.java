package com.lanou.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lanou.entity.Topic;

@Repository
public interface TopicMapper {

	public List<Topic> selectTopic();
	
	public int insertTopic(Topic topic);
	
}
