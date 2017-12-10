package com.lanou.entity;

public class AdGallery {

	private int imgId;
	
	private int adId;
	
	private String adImg;
	
	private String imgSuff;
	
	private String adLink;

	public AdGallery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	public String getAdImg() {
		return adImg;
	}

	public void setAdImg(String adImg) {
		this.adImg = adImg;
	}

	public String getAdLink() {
		return adLink;
	}

	public void setAdLink(String adLink) {
		this.adLink = adLink;
	}

	public String getImgSuff() {
		return imgSuff;
	}

	public void setImgSuff(String imgSuff) {
		this.imgSuff = imgSuff;
	}
}
