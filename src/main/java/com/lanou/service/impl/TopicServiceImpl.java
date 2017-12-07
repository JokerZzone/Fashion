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
	public void addDataInfo(int topicId) {
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
					Goods good = goodsMapper.findGoodsById(Integer.parseInt(goodsId[j]));
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
	}
	
	
	
	
	
	
	
	

}
