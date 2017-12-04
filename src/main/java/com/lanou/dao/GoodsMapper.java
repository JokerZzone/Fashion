package com.lanou.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lanou.entity.Goods;

@Repository
public interface GoodsMapper {
	
	public List<Goods> findGoods(Integer catId);
	
	public Goods findGoodsById(int goodsId);
	
	public List<Goods> findGoodsByPageId(Integer pageId);
	
	public List<Goods> sortByPriceAsc(Integer catId);
	public List<Goods> sortByPriceDesc(Integer catId);
}
