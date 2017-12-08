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
			@RequestParam("pageId") int pageId, @RequestParam("sortId") int sortId) {
		Map<String, Object> maps = goodsService.titleGoods(titleId, chooseId, pageId, sortId);
		return maps;
	}

	// 点击二级分类商品的展示和排序
	@RequestMapping("/secondTitle")
	@ResponseBody
	public Map<String, Object> SecondGoods(@RequestParam("catId") int catId, @RequestParam("chooseId") int chooseId,
			@RequestParam("pageId") int pageId, @RequestParam("sortId") int sortId) {
		Map<String, Object> maps = goodsService.SecondGoods(catId, chooseId, pageId, sortId);
		return maps;
	}
	
	//点击一级分类展示商品
	@RequestMapping("/homePage")
	@ResponseBody
	public Map<String, Object> homePageGoods(@RequestParam("keyId") int keyId, @RequestParam("chooseId") int chooseId,
			@RequestParam("pageId") int pageId, @RequestParam("sortId") int sortId) {
		Map<String, Object> maps = goodsService.homePageGoods(keyId, chooseId, pageId, sortId);
		return maps;
	}

	//查找明星推荐商品
	@RequestMapping("/recommond")
	@ResponseBody
	public List<Goods> recommondGoods() {
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
}
