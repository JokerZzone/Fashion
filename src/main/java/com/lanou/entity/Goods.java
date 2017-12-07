package com.lanou.entity;

public class Goods {

	private Integer goodsId;

	private String goodsName;

	private String goodsDesc;

	private double shopPrice;

	private String goodsUrl;

	private String discount;

	private int clickCount;

	private int isHot;

	private GoodsGallery goodsGallery;

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIsHot() {
		return isHot;
	}

	public void setIsHot(int isHot) {
		this.isHot = isHot;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public double getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}

	public String getGoodsUrl() {
		return goodsUrl;
	}

	public void setGoodsUrl(String goodsUrl) {
		this.goodsUrl = goodsUrl;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public int getClickCount() {
		return clickCount;
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	public GoodsGallery getGoodsGallery() {
		return goodsGallery;
	}

	public void setGoodsGallery(GoodsGallery goodsGallery) {
		this.goodsGallery = goodsGallery;
	}
}
