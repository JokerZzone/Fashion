package com.lanou.entity;

import java.util.List;

public class Ad {

	private int adId;
	
	private String adName;
	
	private String startTime;
	
	private String endTime;
	
	private String imgDesc;
	
	private List<AdGallery> adGalleries;
	
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

	public String getImgDesc() {
		return imgDesc;
	}

	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}

	public List<AdGallery> getAdGalleries() {
		return adGalleries;
	}

	public void setAdGalleries(List<AdGallery> adGalleries) {
		this.adGalleries = adGalleries;
	}
}
