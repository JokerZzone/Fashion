package com.lanou.entity;

import java.util.List;

public class Topic {

	private int topicId;
	
	private String title;
	
	private String startTime;
	
	private String endTime;
	
	private int state;
	
	private String tempGoods;
	
	private String tempBrands;
	
	private Ad ads;
	
	private List<Goods> goods;
	
	private List<Brand> brands;
	
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Ad getAds() {
		return ads;
	}

	public void setAds(Ad ads) {
		this.ads = ads;
	}

	public String getTempGoods() {
		return tempGoods;
	}

	public void setTempGoods(String tempGoods) {
		this.tempGoods = tempGoods;
	}

	public String getTempBrands() {
		return tempBrands;
	}

	public void setTempBrands(String tempBrands) {
		this.tempBrands = tempBrands;
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	public List<Brand> getBrands() {
		return brands;
	}

	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}
}
