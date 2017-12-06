package com.lanou.service;

import java.util.List;

import com.lanou.entity.Category;
import com.lanou.entity.Goods;

public interface GoodsService {
	
	public List<Goods> findGoods(Integer catId);
	
	public List<Goods> findGoodsByPageId(Integer pageId);
	
	public List<Goods> sortByPriceAsc(Integer catId);
	public List<Goods> sortByPriceDesc(Integer catId);
	
	public List<Goods> findGoodsBySecond(Integer cat_id);
	
//  展示一级分类
	public List<Category> showFather();	
	public List<Category> findCategories(Integer parentId);
}
