package com.lanou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lanou.entity.Goods;

@Repository
public interface GoodsMapper {

	// wz
	public Goods findGoodsById(int goodsId);

	// xy
	//title模块
	// 根据标题获取所有商品(分页、排序)
	public List<Goods> findAllGoods(@Param("titleId") int titleId, @Param("chooseId") int chooseId,
			@Param("pageId") int pageId, @Param("sortId") int sortId, @Param("pageCount") int pageCount);

	// 点击超值小样获取所有商品数
	public int goodsTotal(int titleId);

	// 根据标题下的二级分类获取所有商品(分页、排序)
	public List<Goods> findSecondGoods(@Param("catId") int catId, @Param("chooseId") int chooseId,
			@Param("pageId") int pageId, @Param("sortId") int sortId, @Param("pageCount") int pageCount);

	// 获取二级分类的所有商品数量
	public int SecondGoodsTotal(int catId);

	// 首页商品展示
	public List<Goods> showHomePage(@Param("keyId") int keyId, @Param("chooseId") int chooseId,
			@Param("pageId") int pageId, @Param("sortId") int sortId, @Param("pageCount") int pageCount);
	
	//明星推荐
	public List<Goods> recommendGoods();
	
	//清仓
	public List<Goods> saleOut();
	
	//本周特价
	public List<Goods> weeklyGoods(@Param("weeklyId") int weeklyId, @Param("chooseId") int chooseId,
			@Param("pageId") int pageId,@Param("pageCount") int pageCount);
	
	// 获取本周特价商品数量
	public int weeklyGoodsTotal();
	
	//根据商品查询所有商品信息
	public Goods findGoodsNews(int goodsId);
}
