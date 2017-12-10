package com.lanou.entity;

public class GoodsGallery {

	private int imgId;
	
	private int goodsId;
	
	private String goodsImg;
	
	private String imgSuff;

	public GoodsGallery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	public String getImgSuff() {
		return imgSuff;
	}

	public void setImgSuff(String imgSuff) {
		this.imgSuff = imgSuff;
	}
}
