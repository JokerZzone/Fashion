package com.lanou.entity;

import java.util.List;

public class Brand {

	private Integer brandId;

	private String brandName;

	private String brandDesc;

	private int sortOrder;

	private int isShow;
	
	private String imgDesc;

	private List<BrandGallery> brandGalleries;

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

	public List<BrandGallery> getBrandGalleries() {
		return brandGalleries;
	}

	public void setBrandGalleries(List<BrandGallery> brandGalleries) {
		this.brandGalleries = brandGalleries;
	}
}
