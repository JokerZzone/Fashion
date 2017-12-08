package com.lanou.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.dao.GoodsMapper;
import com.lanou.entity.Goods;
import com.lanou.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	private static final Integer PAGE = 36;

	int total = 0;

	int totalPage = 0;

	public Map<String, Object> titleGoods(int titleId, int chooseId, int pageId, int sortId) {
		// TODO Auto-generated method stub
		int pageId2 = (pageId - 1) * PAGE;
		List<Goods> goods = goodsMapper.findAllGoods(titleId, chooseId, pageId2, sortId, 36);
		total = goodsMapper.goodsTotal(titleId);
		totalPage = (int) Math.ceil((double) (total) / (PAGE));
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("total", total);
		maps.put("totalPage", totalPage);
		maps.put("goodList", goods);
		return maps;
	}

	public Map<String, Object> SecondGoods(int catId, int chooseId, int pageId, int sortId) {
		// TODO Auto-generated method stub
		int pageId2 = (pageId - 1) * PAGE;
		List<Goods> goods = goodsMapper.findSecondGoods(catId, chooseId, pageId2, sortId, 36);
		total = goodsMapper.SecondGoodsTotal(catId);
		totalPage = (int) Math.ceil((double) (total) / (PAGE));
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("total", total);
		maps.put("totalPage", totalPage);
		maps.put("goodList", goods);
		return maps;
	}

	public List<Goods> recommendGoods() {
		// TODO Auto-generated method stub
		return goodsMapper.recommendGoods();
	}

	public List<Goods> saleOutGoods() {
		// TODO Auto-generated method stub
		return goodsMapper.saleOut();
	}
}
