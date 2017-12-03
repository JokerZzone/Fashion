package com.lanou.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lanou.entity.Goods;

@Repository
public interface GoodsMapper {
	
	public List<Goods> findAllGoods();
	
	public Goods findGoodsById(int goodsId);
}
