package com.lanou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.stereotype.Repository;

import com.lanou.entity.Goods;

@Repository
public interface GoodsMapper {

	// wz
	public Goods findGoodsById(int goodsId);
	
	public Goods findGoods(int goodsId);
	
	public Goods findGoodsToIndex(int goodsId);

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
	public int homePageGoodsTotal(int keyId);
	
	//明星推荐
	public List<Goods> recommendGoods();
	
	//清仓
	public List<Goods> saleOut();
	
	//本周特价
	public List<Goods> weeklyGoods(@Param("chooseId") int chooseId,@Param("orders") int orders,
			@Param("pageId") int pageId,@Param("pageCount") int pageCount);
	
	// 获取本周特价商品数量
	public int weeklyGoodsTotal();

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
	
	//首页商品的模糊查询
	public List<Goods> findPageGoods(@Param("name")String name, @Param("chooseId") int chooseId,
			@Param("pageId") int pageId, @Param("sortId") int sortId,
			@Param("pageCount") int pageCount);
	
	//获取模糊查询的商品的总数
	public int likeGoodsTotal(@Param("name")String name);

	/**
	 * xy
	 * 卖家功能
	 * 商品列表
	 */
	
	//获取商品总数
	public int goodsCount();
	
	//1.展示所有商品信息
	public List<Goods> allGoodsNews(@Param("pageId")int pageId,@Param("pageNumber")int pageNumber);
	
	//根据一级分类查找商品
	public List<Goods> firstGoods(@Param("catId")int catId,@Param("pageId")int pageId,@Param("pageNumber")int pageNumber);
	
	//获取一级分类总数
	public int firstGoodsCount(int catId);
	
	//模糊查询功能
	public List<Goods> likes(@Param("name")String name,@Param("pageId")int pageId,@Param("pageNumber")int pageNumber);
	
	//模糊查询的结果的商品数量
	public int likesCount(@Param("name")String name);
	
	//查看功能
	public Goods goodNews(@Param("goodsId")int goodsId);
	
	//编辑功能
	public boolean updateGoods(Goods good);
	
	//删除功能
	public boolean deleteGood(@Param("goodsId")int goodsId);
	
	//2.添加新商品
	public boolean addGood(Goods good);
	
	//5.商品回收站
	public List<Goods> deletedGoods(@Param("pageId")int pageId,@Param("pageNumber")int pageNumber);

	//回收站商品的总数
	public int deletedGoodsCount();
	
	//商品回收站的模糊查询
	public List<Goods> likeDeleteGoods(@Param("name")String name,@Param("pageId")int pageId,@Param("pageNumber")int pageNumber);
	
	//商品回收站的模糊查询的商品数量
	public int likeDeleteGoodsCount(@Param("name")String name);
	
	//商品回收站还原
	public boolean restoreGood(@Param("goodId")int goodId);
	
	//商品回收站彻底删除
	public boolean physicalDelete(@Param("goodId")int goodId);
	
	
	
}
