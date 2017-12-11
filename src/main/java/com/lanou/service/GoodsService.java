package com.lanou.service;

import java.util.List;
import java.util.Map;

import com.lanou.entity.Goods;

public interface GoodsService {

	// xy
	// 根据标题进行展示，分页，排序
	public Map<String, Object> titleGoods(int titleId, int chooseId, int pageId, int sortId,int brandId,String[] attr_idAndType);

	// 根据二级分类的商品进行展示，分页，排序
	public Map<String, Object> SecondGoods(int catId, int chooseId, int pageId, int sortId,int brandId,String[] attr_idAndType);

	//展示明星推荐商品
	public List<Goods> recommendGoods(); 
	
	//展示清仓商品
	public List<Goods> saleOutGoods(); 
	
	//展示本周特价
	public Map<String, Object> weeklyGoods(int weeklyId, int chooseId, int pageId);

}
