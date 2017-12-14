package com.lanou.entity;

import java.util.List;

public class Category {

	private Integer catId;

	private String catName;

	private Integer parentId;
	
	private int sortOrder;
	
	private int showInNav;
	
	private int isShow;
	
	private String style;
	
	private int goodNumber;

	private List<Category> categories;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCatId() {
		return catId;
	}
	
	public int getGoodNumber() {
		return goodNumber;
	}

	public void setGoodNumber(int goodNumber) {
		this.goodNumber = goodNumber;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public int getShowInNav() {
		return showInNav;
	}

	public void setShowInNav(int showInNav) {
		this.showInNav = showInNav;
	}

	public int getIsShow() {
		return isShow;
	}

	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
}
