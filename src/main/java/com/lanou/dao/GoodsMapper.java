package com.lanou.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lanou.entity.Category;
import com.lanou.entity.Goods;

@Repository
public interface GoodsMapper {

	public List<Goods> findGoods(Integer catId);
	
	public Goods findGoodsById(int goodsId);
	
	public List<Goods> findGoodsByPageId(Integer pageId);
	
	public List<Goods> sortByPriceAsc(Integer catId);
	public List<Goods> sortByPriceDesc(Integer catId);

//	根据第二分类查找商品
	public List<Goods> findGoodsBySecond(Integer cat_id);
	
//	展示商品数量	
	public List<Category> findCategories(Integer parentId);
//  展示一级分类
	public List<Category> showFather();

	
	
	
	
	
	
	
	
	
	
	
}
