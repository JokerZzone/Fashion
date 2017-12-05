package com.lanou.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanou.dao.AdMapper;
import com.lanou.dao.BrandMapper;
import com.lanou.dao.GoodsMapper;
import com.lanou.dao.TopicMapper;
import com.lanou.entity.Ad;
import com.lanou.entity.Brand;
import com.lanou.entity.Goods;
import com.lanou.entity.Topic;
import com.lanou.service.TopicService;

@Service("topicService")
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicMapper topicMapper;
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Autowired
	private BrandMapper brandMapper;
	
	@Autowired
	private AdMapper adMapper;
	
	@Transactional
	public Topic showTopic(int topicId) {
		Topic topic = topicMapper.selectTopic(topicId);
		return topic;
	}

	@Transactional
	public List<Goods> addDataInfo(int topicId) {
		Topic topic = topicMapper.selectTopic(topicId);
		String data = topic.getData();
		String str[] = data.split("!");
		List<Goods> goods = new ArrayList<Goods>();
		List<Brand> brands = new ArrayList<Brand>();
		List<Ad> ads = new ArrayList<Ad>();
		for (int i = 0; i < str.length; i++) {
			if (str[i].contains("goods")) {
				String[] goodsId = str[i].split("goods:")[1].split("#");
				for (int j = 0; j < goodsId.length; j++) {
					Goods good = goodsMapper.findGoods(Integer.parseInt(goodsId[j]));
					goods.add(good);
				}
			}else if(str[i].contains("brand")){
				String[] brandId = str[i].split("brand:")[1].split("#");
				for (int j = 0; j < brandId.length; j++) {
					Brand brand = brandMapper.findBrandById(Integer.parseInt(brandId[j]));
					brands.add(brand);
				}
			}else if (str[i].contains("ad")) {
				String[] adId = str[i].split("ad:")[1].split("#");
				for (int j = 0; j < adId.length; j++) {
					Ad ad = adMapper.findAdById(Integer.parseInt(adId[j]));
					ads.add(ad);
				}
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goods", goods);
		map.put("brands", brands);
		map.put("ads", ads);
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int a = topicMapper.addDataInfo(json, topicId);
		System.out.println(a);
		
//		ObjectMapper mapper = new ObjectMapper();
//		
//		List<Goods> list = goodsMapper.findGoodsById(9);
//		try {
//			String json = mapper.writeValueAsString(list);
//			System.out.println(json);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
//		List<Brand> brands = new ArrayList<Brand>();
//		try {
//			for (int i = 1; i < 5; i++) {
//				Brand brand = brandMapper.findBrandById(i);
//				brands.add(brand);
//			}
//			String json = mapper.writeValueAsString(brands);
//			System.out.println(json);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
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
