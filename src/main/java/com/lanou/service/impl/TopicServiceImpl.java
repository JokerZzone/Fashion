package com.lanou.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanou.dao.GoodsMapper;
import com.lanou.dao.TopicMapper;
import com.lanou.entity.Goods;
import com.lanou.entity.Topic;
import com.lanou.service.TopicService;
import com.lanou.util.PropertyConfigurer;

@Service("topicService")
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicMapper mapper;
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Autowired
	private PropertyConfigurer prop;
	
	@Transactional
	public Topic showTopic(int topicId) {
		Topic topic = mapper.selectTopic(topicId);
//		ObjectMapper mapper = new ObjectMapper();
//		String json = null;
//		try {
//			json = mapper.writeValueAsString(topic.getDataInfo());
//			System.out.println(json);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		topic.setDataInfo(json);
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(topic.getDataInfo());
		return topic;
	}

	@Transactional
	public List<Goods> addTopic() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(goodsMapper.findGoodsById(1));
			System.out.println(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return goodsMapper.findGoodsById(1);
		
		
		
		
		
		
		
//		String dataPath = prop.getProperty("dataPath");
//		String context[] = {"1-data.txt","1-template.txt","1-css.txt"};
//		BufferedReader br = null;
//		String str = new String();
//		try {
//			for (int i = 0; i < context.length; i++) {
//				String path = dataPath + context[i];
//				br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "gbk"));
//				String temp = br.readLine();
//				while (temp != null) {
//					str += temp; 
//					temp = br.readLine();
//				}
//				str += prop.getProperty("character");
//			}
//		} catch (FileNotFoundException e) {
//			
//			e.printStackTrace();
//		} catch (IOException e) {
//		
//			e.printStackTrace();
//		}
//		String[] res = str.split(prop.getProperty("character"));
//		Topic topic = new Topic(res[0],res[1],res[2]);
		
//		Topic topic = new Topic();
//		String str = "2017-01-10 12:00:00";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date = null;
//		try {
//			date = sdf.parse(str);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		}
//		topic.setStartTime(str);
//		return mapper.insertTopic(topic);
	}
	
	
	
	
	
	
	
	
	
	
	

}
