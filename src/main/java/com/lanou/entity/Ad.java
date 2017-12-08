package com.lanou.entity;

import java.util.List;

public class Ad {

	private int adId;
	
	private String adName;
	
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

	public List<AdGallery> getAdGalleries() {
		return adGalleries;
	}

	public void setAdGalleries(List<AdGallery> adGalleries) {
		this.adGalleries = adGalleries;
	}
}
