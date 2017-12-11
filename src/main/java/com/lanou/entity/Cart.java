package com.lanou.entity;

public class Cart {

	private int recId;
	
	private int userId;
	
	private String sessionId;
	
	private int goodsId;
	
	private int parentId;
	
	private String goodsName;
	
	private double shopPrice;
	
	private int goodsNumber;
	
	public Cart(int userId, String sessionId, int goodsId, int parentId, String goodsName, double shopPrice,
			int goodsNumber) {
		super();
		this.userId = userId;
		this.sessionId = sessionId;
		this.goodsId = goodsId;
		this.parentId = parentId;
		this.goodsName = goodsName;
		this.shopPrice = shopPrice;
		this.goodsNumber = goodsNumber;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRecId() {
		return recId;
	}

	public void setRecId(int recId) {
		this.recId = recId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
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

	public int getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
}