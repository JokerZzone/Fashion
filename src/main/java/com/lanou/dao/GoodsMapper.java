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
	public List<Goods> findAllGoods(
			@Param("titleId") int titleId, 
			@Param("chooseId") int chooseId,
			@Param("pageId") int pageId, 
			@Param("sortId") int sortId, 
			@Param("pageCount") int pageCount,
			@Param("brandId") int brandId,
			@Param("typeId1") int typeId1,
			@Param("typeId2") int typeId2,
			@Param("typeId3") int typeId3,
			@Param("typeId4") int typeId4,
			@Param("typeId5") int typeId5,
			@Param("typeId6") int typeId6,
			@Param("typeId7") int typeId7,
			@Param("typeId8") int typeId8
		);

	// 点击超值小样获取所有商品数
	public int goodsTotal(
			@Param("titleId") int titleId, 
			@Param("brandId") int brandId,
			@Param("typeId1") int typeId1,
			@Param("typeId2") int typeId2,
			@Param("typeId3") int typeId3,
			@Param("typeId4") int typeId4,
			@Param("typeId5") int typeId5,
			@Param("typeId6") int typeId6,
			@Param("typeId7") int typeId7,
			@Param("typeId8") int typeId8
		);

	// 根据标题下的二级分类获取所有商品(分页、排序)
	public List<Goods> findSecondGoods(
			@Param("catId") int catId,
			@Param("chooseId") int chooseId,
			@Param("pageId") int pageId, 
			@Param("sortId") int sortId, 
			@Param("pageCount") int pageCount,
			@Param("brandId") int brandId,
			@Param("typeId1") int typeId1,
			@Param("typeId2") int typeId2,
			@Param("typeId3") int typeId3,
			@Param("typeId4") int typeId4,
			@Param("typeId5") int typeId5,
			@Param("typeId6") int typeId6,
			@Param("typeId7") int typeId7,
			@Param("typeId8") int typeId8
		);

	// 获取二级分类的所有商品数量
	public int SecondGoodsTotal(
			@Param("catId") int catId,
			@Param("brandId") int brandId,
			@Param("typeId1") int typeId1,
			@Param("typeId2") int typeId2,
			@Param("typeId3") int typeId3,
			@Param("typeId4") int typeId4,
			@Param("typeId5") int typeId5,
			@Param("typeId6") int typeId6,
			@Param("typeId7") int typeId7,
			@Param("typeId8") int typeId8
		);

	// 首页商品展示
	public List<Goods> showHomePage(@Param("keyId") int keyId, @Param("chooseId") int chooseId,
			@Param("pageId") int pageId, @Param("sortId") int sortId, @Param("pageCount") int pageCount);
	
	//首页商品数量
	public int  homePageGoodsTotal(int keyId);
	
	
	
	//明星推荐
	public List<Goods> recommendGoods();
	
	//清仓
	public List<Goods> saleOut();

	/**
	 * sp
	 * 
	 */
	public List<Goods> selectGoodsAttr_idByTitle(
			@Param("titleId") int titleId,
			@Param("brandId") int brandId,
			@Param("typeId1") int typeId1,
			@Param("typeId2") int typeId2,
			@Param("typeId3") int typeId3,
			@Param("typeId4") int typeId4,
			@Param("typeId5") int typeId5,
			@Param("typeId6") int typeId6,
			@Param("typeId7") int typeId7,
			@Param("typeId8") int typeId8
		);
	
	public List<Goods> selectGoodsAttr_idByCate(
			@Param("catId") int catId,
			@Param("brandId") int brandId,
			@Param("typeId1") int typeId1,
			@Param("typeId2") int typeId2,
			@Param("typeId3") int typeId3,
			@Param("typeId4") int typeId4,
			@Param("typeId5") int typeId5,
			@Param("typeId6") int typeId6,
			@Param("typeId7") int typeId7,
			@Param("typeId8") int typeId8);

}
