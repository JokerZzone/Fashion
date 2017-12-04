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
	int total = 0;
	int totalPage = 0;
	@Autowired
	private GoodsService goodsService;
	
//	根据第一分类展示所有商品
	@RequestMapping("/findGoods.do")
	@ResponseBody
	public List<Goods> findGoods(Integer catId) {
		List<Goods> goods = goodsService.findGoods(catId);
		return goods;
	}
	
//	面部护理展示,分页 
//  同时也是销量分类的展示	
	@RequestMapping("/findGoodsByPageId.do")
	@ResponseBody
	public Map<String, Object> findGoodsByPageId(Integer catId,Integer pageId) {
		total = findGoods(catId).size();
		totalPage = (int)Math.ceil((double)(total)/(PAGE));
		List<Goods> goods = findGoods(catId);
		List<Goods> goodList = new ArrayList<Goods>();
		Goods good = new Goods();
		int n =0;
		if(pageId<totalPage) {
			n = PAGE*(pageId-1);
			int m = PAGE*pageId-1;
			for(;n<m;n++) {
				good = goods.get(n);
				goodList.add(good);
			}
		}else {
			n = PAGE*(pageId-1);
			for(;n<goods.size();n++) {
				good = goods.get(n);
				goodList.add(good);
			}
		}
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("total", total);
		maps.put("totalPage", totalPage);
		maps.put("goodList", goodList);
		return maps;	
	}
	
////	根据价格升序，并且分页
	@RequestMapping("/sortByPriceAsc.do")
	@ResponseBody
	public Map<String, Object> PriceAscPage(Integer catId,Integer pageId) {
		total = findGoods(catId).size();
		totalPage = (int)Math.ceil((double)(total)/(PAGE));
		List<Goods> goods = sortByPriceAsc(catId);
		List<Goods> goodList = new ArrayList<Goods>();
		Goods good = new Goods();
		int n =0;
		if(pageId<totalPage) {
			n = PAGE*(pageId-1);
			int m = PAGE*pageId-1;
			for(;n<m;n++) {
				good = goods.get(n);
				goodList.add(good);
			}
		}else {
			n = PAGE*(pageId-1);
			for(;n<goods.size();n++) {
				good = goods.get(n);
				goodList.add(good);
			}	
		}
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("total", total);
		maps.put("totalPage", totalPage);
		maps.put("goodList", goodList);
		return maps;	
	}
	public List<Goods> sortByPriceAsc(Integer catId) {
		List<Goods> goods = goodsService.sortByPriceAsc(catId);
		return goods;
	}
	
////	根据价格降序，并且分页	
	@RequestMapping("/sortByPriceDesc.do")
	@ResponseBody
	 public Map<String, Object> PriceDescPage(Integer catId,Integer pageId) {
		total = findGoods(catId).size();
		totalPage = (int)Math.ceil((double)(total)/(PAGE));
		List<Goods> goods = sortByPriceDesc(catId);
		List<Goods> goodList = new ArrayList<Goods>();
		Goods good = new Goods();
		int n =0;
		if(pageId<totalPage) {
			n = PAGE*(pageId-1);
			int m = PAGE*pageId-1;
			for(;n<m;n++) {
				good = goods.get(n);
				goodList.add(good);
			}
		}else {
			n = PAGE*(pageId-1);
			for(;n<goods.size();n++) {
				good = goods.get(n);
				goodList.add(good);
			}
		}
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("total", total);
		maps.put("totalPage", totalPage);
		maps.put("goodList", goodList);
		return maps;	
	 }
	public List<Goods> sortByPriceDesc(Integer catId) {
		List<Goods> goods = goodsService.sortByPriceDesc(catId);
		return goods;
	}
	
//	根据好评度降序
//	根据上架时间降序
	
	
	
	
}
