package com.lanou.service;

import java.util.List;
import java.util.Map;

import com.lanou.entity.Goods;

public interface GoodsService {

	// 根据标题进行展示，分页，排序
	public Map<String, Object> titleGoods(int titleId, int chooseId, int pageId, int sortId,int brandId,String[] attr_idAndType);

	// 根据二级分类的商品进行展示，分页，排序
	public Map<String, Object> SecondGoods(int catId, int chooseId, int pageId, int sortId,int brandId,String[] attr_idAndType);

	//展示明星推荐商品
	public List<Goods> recommendGoods(); 
	
	//展示清仓商品
	public List<Goods> saleOutGoods(); 
	
	//展示本周特价
	public Map<String, Object> weeklyGoods(int chooseId,int orders, int pageId);
	
	public Goods findGoods(int goodsId);
	
	//页面的模糊查询
	public Map<String, Object> findGoods(String name, int chooseId, int pageId, int sortId);

	
	/**
	 * 卖家功能 
	 */
	//1.展示所有商品信息
	public Map<String, Object> allGoodsNews(int pageId,int pageNumber);
	
	//查看单个商品信息
	public Goods goodNews(int goodsId);
	
	//根据一级分类查看商品
	public Map<String, Object> firstGoods(int catId,int pageId,int pageNumber);
	
	//模糊查询的功能
	public Map<String, Object> likesGoods(String name,int pageId,int pageNumber);
	
	//修改单个商品信息
	public boolean updateGood(Goods good);
	
	//删除商品信息
	public boolean deleteGood(int goodsId);
	
	//添加商品信息
	public boolean addGood(Goods good);
	
	//5.查看已经删除的商品的信息
	public Map<String, Object> findDeletedGoods(int pageId,int pageNumber);
	
	//删除商品的模糊查询
	public Map<String, Object> likeDeleteGoods(String name,int pageId,int pageNumber);
	
	//还原商品
	public boolean restoreGood(int goodId);
	
	//物理删除
	public boolean physicalDelete(int goodId);
}
