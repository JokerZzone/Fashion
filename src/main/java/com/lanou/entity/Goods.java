package com.lanou.entity;

public class Goods {
	
	private Integer goodsId;
	private String goodsName;
	
	private double shopPrice;

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", shopPrice=" + shopPrice + "]";
	}

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
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

	public double getShopPrice() {
		return shopPrice;
	}

	public void setShopPrice(double shopPrice) {
		this.shopPrice = shopPrice;
	}
}
