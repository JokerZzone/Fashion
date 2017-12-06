package com.lanou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanou.dao.GoodsMapper;
import com.lanou.entity.Category;
import com.lanou.entity.Goods;
import com.lanou.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsMapper goodsMapper;
	
	@Transactional
	public List<Goods> findGoods(Integer catId) {
		// TODO Auto-generated method stub
		return goodsMapper.findGoods(catId);
	}

	public List<Goods> findGoodsByPageId(Integer pageId) {
		// TODO Auto-generated method stub
		return goodsMapper.findGoodsByPageId(pageId);
	}

	public List<Goods> sortByPriceAsc(Integer catId) {
		// TODO Auto-generated method stub
		return goodsMapper.sortByPriceAsc(catId);
	}
	public List<Goods> sortByPriceDesc(Integer catId) {
		// TODO Auto-generated method stub
		return goodsMapper.sortByPriceDesc(catId);
	}

	public List<Goods> findGoodsBySecond(Integer cat_id) {
		// TODO Auto-generated method stub
		return goodsMapper.findGoodsBySecond(cat_id);
	}

	public List<Category> findCategories(Integer parentId) {
		// TODO Auto-generated method stub
		return goodsMapper.findCategories(parentId);
	}

	public List<Category> showFather() {
		// TODO Auto-generated method stub
		return goodsMapper.showFather();
	}

	


}
