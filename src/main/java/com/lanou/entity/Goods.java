package com.lanou.entity;

public class Goods {
	
	private Integer goodsId;
	private String goodsName;
	
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
	public Goods(Integer goodsId, String goodsName) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + "]";
	}
	
}
