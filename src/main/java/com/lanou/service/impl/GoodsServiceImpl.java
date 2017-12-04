package com.lanou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanou.dao.GoodsMapper;
import com.lanou.entity.Goods;
import com.lanou.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsMapper goodsMapper;
	
	@Transactional
	public List<Goods> findAllGoods(Integer catId) {
		// TODO Auto-generated method stub
		return goodsMapper.findAllGoods(catId);
	}

	public List<Goods> findGoodsByPageId(Integer pageId) {
		// TODO Auto-generated method stub
		return goodsMapper.findGoodsByPageId(pageId);
	}

	public List<Goods> sortByPriceAsc() {
		// TODO Auto-generated method stub
		return goodsMapper.sortByPriceAsc();
	}
	public List<Goods> sortByPriceDesc() {
		// TODO Auto-generated method stub
		return goodsMapper.sortByPriceDesc();
	}

}
