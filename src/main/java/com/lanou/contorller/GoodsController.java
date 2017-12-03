package com.lanou.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.entity.Goods;
import com.lanou.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/findAllGoods.do")
	@ResponseBody
	public List<Goods> findAllGoods() {
		List<Goods> goods = goodsService.findAllGoods();
		return goods;
	}
}
