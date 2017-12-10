package com.lanou.entity;

import java.util.List;

public class Goods {

	private Integer goodsId;

	private String goodsName;
	
	private String goodsNameEn;

	private String goodsDesc;
	
	private double marketPrice;
	
	private double shopPrice;
	
	private String discount;

	private String imgDesc;
	
	private int clickCount;

	private int isHot;

	private Brand subBrand;
	
	private Category subCategory;
	
	private List<GoodsGallery> goodsGalleries;
	
	//sp
	private String goodsAttr_id;
	
	private Integer brandId;

	public Goods(Integer goodsId, String goodsAttr_id, Integer brandId) {
		super();
		this.goodsId = goodsId;
		this.goodsAttr_id = goodsAttr_id;
		this.brandId = brandId;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsNameEn=" + goodsNameEn
				+ ", goodsDesc=" + goodsDesc + ", marketPrice=" + marketPrice + ", shopPrice=" + shopPrice
				+ ", discount=" + discount + ", imgDesc=" + imgDesc + ", clickCount=" + clickCount + ", isHot=" + isHot
				+ ", subBrand=" + subBrand + ", subCategory=" + subCategory + ", goodsGalleries=" + goodsGalleries
				+ "]";
	}

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

	public String getGoodsNameEn() {
		return goodsNameEn;
	}

	public void setGoodsNameEn(String goodsNameEn) {
		this.goodsNameEn = goodsNameEn;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public double getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getImgDesc() {
		return imgDesc;
	}

	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}

	public int getClickCount() {
		return clickCount;
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	public Brand getSubBrand() {
		return subBrand;
	}

	public void setSubBrand(Brand subBrand) {
		this.subBrand = subBrand;
	}

	public Category getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(Category subCategory) {
		this.subCategory = subCategory;
	}

	public List<GoodsGallery> getGoodsGalleries() {
		return goodsGalleries;
	}

	public void setGoodsGalleries(List<GoodsGallery> goodsGalleries) {
		this.goodsGalleries = goodsGalleries;
	}
	
	public String getGoodsAttr_id() {
		return goodsAttr_id;
	}

	public void setGoodsAttr_id(String goodsAttr_id) {
		this.goodsAttr_id = goodsAttr_id;
	}	

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

}
