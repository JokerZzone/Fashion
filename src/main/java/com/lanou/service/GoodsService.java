package com.lanou.service;

import java.util.List;

import com.lanou.entity.Goods;

public interface GoodsService {
	
	public List<Goods> findGoods(Integer catId);
	
	public List<Goods> findGoodsByPageId(Integer pageId);
	
	public List<Goods> sortByPriceAsc(Integer catId);
	public List<Goods> sortByPriceDesc(Integer catId);
}
