package com.lanou.service;

import java.util.List;
import java.util.Map;

import com.lanou.entity.Goods;

public interface GoodsService {

	// xy
	// 根据标题进行展示，分页，排序
	public Map<String, Object> titleGoods(int titleId, int chooseId, int pageId, int sortId);

	// 根据二级分类的商品进行展示，分页，排序
	public Map<String, Object> SecondGoods(int catId, int chooseId, int pageId, int sortId);

	//点击一级分类的商品的展示 
	public Map<String, Object> homePageGoods(int keyId, int chooseId, int pageId, int sortId);
	
	//展示明星推荐商品
	public List<Goods> recommendGoods(); 
	
	//展示清仓商品
	public List<Goods> saleOutGoods(); 
}
