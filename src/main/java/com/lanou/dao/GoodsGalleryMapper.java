package com.lanou.dao;

import org.springframework.stereotype.Repository;

import com.lanou.entity.Goods;

@Repository
public interface GoodsGalleryMapper {
	
	//wz
	public Goods findGoodsGalleryById(int goodsId);
	
	public int updateImgDesc(String json, int imgId);
}
