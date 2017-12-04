package com.lanou.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lanou.entity.Goods;

@Repository
public interface GoodsMapper {
	
	public List<Goods> findAllGoods(Integer catId);
	
	public List<Goods> findGoodsById(int topicId);
	
	public List<Goods> findGoodsByPageId(Integer pageId);
	
	public List<Goods> sortByPriceAsc();
	public List<Goods> sortByPriceDesc();
}
