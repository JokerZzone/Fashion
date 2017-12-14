package com.lanou.entity;

import java.util.List;

public class Brand {

	private Integer brandId;

	private String brandName;

	private String brandDesc;

	private int sortOrder;

	private int isShow;
	
	private String imgDesc;
	
	private List<String> imgPre;

	private List<String> detailImg;
	
	private List<String> imgSuff;
	
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandDesc() {
		return brandDesc;
	}

	public void setBrandDesc(String brandDesc) {
		this.brandDesc = brandDesc;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public int getIsShow() {
		return isShow;
	}

	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}

	public String getImgDesc() {
		return imgDesc;
	}

	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
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
