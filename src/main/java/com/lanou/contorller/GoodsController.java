package com.lanou.contorller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Goods;
import com.lanou.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	private static final Integer PAGE = 36;
	@Autowired
	private GoodsService goodsService;
	
//	根据第一分类展示所有商品
	@RequestMapping("/findAllGoods.do")
	@ResponseBody
	public List<Goods> findAllGoods(Integer catId) {
		List<Goods> goods = goodsService.findAllGoods(catId);
		return goods;
	}
	
//	面部护理展示,分页 
//  同时也是销量分类的展示	
	@RequestMapping("/findGoodsByPageId.do")
	@ResponseBody
	public Map<String, Object> findGoodsByPageId(Integer catId,Integer pageId) {
		int goodsId = 1+PAGE*(pageId-1);
		int totalPage = (int)Math.ceil((double)(findAllGoods(catId).size())/(PAGE));
		List<Goods> goods = goodsService.findGoodsByPageId(goodsId);
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("totalPage", totalPage);
		maps.put("goods", goods);
		return maps;	
	}
	
//	根据价格升序，并且分页
	@RequestMapping("/sortByPriceAsc.do")
	@ResponseBody
	 public Map<String, Object> PriceAscPage(Integer pageId) {
		List<Goods> goodList2 = sortByPriceAsc(); 
		int i = (pageId-1)*PAGE;
		int j = pageId*PAGE;
		int totalPage = (int)Math.ceil((double)(goodList2.size())/PAGE);
		List<Goods> goodList = new ArrayList<Goods>();
		Map<String, Object> maps = new HashMap<String, Object>();
		for(;i<j;i++) {
			Goods goods = goodList2.get(i);
			goodList.add(goods);
			maps.put("totalPage", totalPage);
			maps.put("goodList", goodList);
		}
		return maps;
	 }
	public List<Goods> sortByPriceAsc() {
		List<Goods> goods = goodsService.sortByPriceAsc();
		return goods;
	}
	
//	根据价格降序，并且分页	
	@RequestMapping("/sortByPriceDesc.do")
	@ResponseBody
	 public Map<String, Object> PriceDescPage(Integer pageId) {
		List<Goods> goodList2 = sortByPriceDesc(); 
		int i = (pageId-1)*PAGE;
		int j = pageId*PAGE;
		int totalPage = (int)Math.ceil((double)(goodList2.size())/PAGE);
		List<Goods> goodList = new ArrayList<Goods>();
		Map<String, Object> maps = new HashMap<String, Object>();
		for(;i<j;i++) {
			Goods goods = goodList2.get(i);
			goodList.add(goods);
			maps.put("totalPage", totalPage);
			maps.put("goodList", goodList);
		}
		return maps;
	 }
	public List<Goods> sortByPriceDesc() {
		List<Goods> goods = goodsService.sortByPriceDesc();
		return goods;
	}
	
//	根据好评度降序
//	根据上架时间降序
	
	
	
	
}
