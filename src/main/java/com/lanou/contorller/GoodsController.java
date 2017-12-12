package com.lanou.contorller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Goods;
import com.lanou.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	// 点击标题商品的展示和排序
	@RequestMapping("/title")
	@ResponseBody
	public Map<String, Object> TitleGoods(@RequestParam("titleId") int titleId, @RequestParam("chooseId") int chooseId,
			@RequestParam("pageId") int pageId, @RequestParam("sortId") int sortId,
			@RequestParam(value = "brandId", required = false, defaultValue = "0") int brandId,
			@RequestParam(value = "attr_idAndType", required = false, defaultValue = "") String[] attr_idAndType

	) {
		// String[] attr_idAndType = {"1","1","14","2","18","3"};
		Map<String, Object> maps = goodsService.titleGoods(titleId, chooseId, pageId, sortId, brandId, attr_idAndType);
		return maps;
	}

	// 点击二级分类商品的展示和排序
	@RequestMapping("/secondTitle")
	@ResponseBody
	public Map<String, Object> SecondGoods(@RequestParam("catId") int catId, @RequestParam("chooseId") int chooseId,
			@RequestParam("pageId") int pageId, @RequestParam("sortId") int sortId,
			@RequestParam(value = "brandId", required = false, defaultValue = "0") int brandId,
			@RequestParam(value = "attr_idAndType", required = false, defaultValue = "") String[] attr_idAndType) {
		// String[] attr_idAndType = {"1","1","14","2","18","3"};
		Map<String, Object> maps = goodsService.SecondGoods(catId, chooseId, pageId, sortId, brandId, attr_idAndType);
		return maps;
	}

	// 查找明星推荐商品
	@RequestMapping("/recommend")
	@ResponseBody
	public List<Goods> recommendGoods() {
		List<Goods> goods = goodsService.recommendGoods();
		return goods;
	}

	// 查找清仓商品
	@RequestMapping("/sale")
	@ResponseBody
	public List<Goods> saleOutGoods() {
		List<Goods> goods = goodsService.saleOutGoods();
		return goods;
	}

	// 本周特价商品
	@RequestMapping("/weekly")
	@ResponseBody
	public Map<String, Object> weeklyGoods(@RequestParam("weeklyId") int weeklyId,
			@RequestParam("chooseId") int chooseId, @RequestParam("pageId") int pageId) {
		Map<String, Object> maps = goodsService.weeklyGoods(weeklyId, chooseId, pageId);
		return maps;
	}

	@RequestMapping("/detail")
	public Goods detail(@RequestParam("id") int goodsId) {
		return goodsService.findGoods(goodsId);
	}
	
	/**
	 * 卖家功能  
	 */
	//1.展示商品信息
	@RequestMapping("/goodsNews")
	@ResponseBody
	public Map<String, Object> lookGoodsNews(@RequestParam("pageId")int pageId,@RequestParam("pageNumber")int pageNumber) {
		Map<String, Object> maps = goodsService.allGoodsNews(pageId, pageNumber);
		return maps;
	}
	
	//筛选一级分类商品
	@RequestMapping("/firstGoods")
	@ResponseBody
	public Map<String, Object> lookFirstGoods(@RequestParam("catId")int catId,@RequestParam("pageId")int pageId,@RequestParam("pageNumber")int pageNumber) {
		Map<String, Object> maps = goodsService.firstGoods(catId, pageId, pageNumber);
		return maps;
	}
	
	//模糊查询
	@RequestMapping("/likeGoods")
	@ResponseBody
	public Map<String, Object> findLikeGoods(@RequestParam("name")String name,@RequestParam("pageId")int pageId,@RequestParam("pageNumber")int pageNumber) {
		Map<String, Object> maps = goodsService.likesGoods(name, pageId, pageNumber);
		return maps;
	}
	
	//查看单个商品信息
	@RequestMapping("/oneGoodNews")
	@ResponseBody
	public Goods oneGoodNews(@RequestParam("goodsId")int goodsId) {
		Goods good = goodsService.goodNews(goodsId);
		return good;
	}
	
	//修改单个商品信息
	@RequestMapping("/updateGood")
	@ResponseBody
	public boolean updateGoodNews(Goods good) {
		boolean result = goodsService.updateGood(good);
		return result;
	}
	
	//删除商品功能
	@RequestMapping("/deleteGood")
	@ResponseBody
	public boolean deleteGoodNews(@RequestParam("goodsId")int goodsId) {
		boolean result = goodsService.deleteGood(goodsId);
		return result;
	}
	
	//添加商品
	@RequestMapping("/addGood")
	@ResponseBody
	public boolean addGoodNews(Goods good) {
		boolean result = goodsService.addGood(good);
		return result;
	}

}
