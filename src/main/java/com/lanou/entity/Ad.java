package com.lanou.entity;

import java.util.List;

public class Ad {

	private int adId;
	
	private String adName;
	
	private String startTime;
	
	private String endTime;
	
	private List<String> imgPre;
	
	private List<String> detailImg;
	
	private List<String> imgSuff;
	
	public Ad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
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
	
	public List<String> getDetailImg() {
		return detailImg;
	}

	public void setDetailImg(List<String> detailImg) {
		this.detailImg = detailImg;
	}

	public List<String> getImgSuff() {
		return imgSuff;
	}

	public void setImgSuff(List<String> imgSuff) {
		this.imgSuff = imgSuff;
	}

	public List<String> getImgPre() {
		return imgPre;
	}

	public void setImgPre(List<String> imgPre) {
		this.imgPre = imgPre;
	}
}
