package com.lanou.service.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanou.dao.TopicMapper;
import com.lanou.entity.Topic;
import com.lanou.service.TopicService;
import com.lanou.util.PropertyConfigurer;

@Service("topicService")
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicMapper mapper;
	
	@Autowired
	private PropertyConfigurer prop;
	
	@Transactional
	public List<Topic> showTopic() {
		
		return mapper.selectTopic();
	}

	@Transactional
	public int addTopic() {
		String dataPath = prop.getProperty("dataPath");
		String context[] = {"1-data.txt","1-template.txt","1-css.txt"};
		BufferedReader br = null;
		String str = new String();
		try {
			for (int i = 0; i < context.length; i++) {
				String path = dataPath + context[i];
				br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "gbk"));
				String temp = br.readLine();
				while (temp != null) {
					str += temp; 
					temp = br.readLine();
				}
				str += prop.getProperty("character");
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		String[] res = str.split(prop.getProperty("character"));
		Topic topic = new Topic(res[0],res[1]);
		return mapper.insertTopic(topic);
	}

}
