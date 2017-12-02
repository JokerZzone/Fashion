package com.lanou.entity;

import java.util.List;

public class Category {
	
	private Integer catId;
	private String catName;
	private Integer parentId;
	private List<Category> categories;
	
	
	public Integer getCatId() {
		return catId;
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

	public Category(Integer catId, String catName, Integer parentId, List<Category> categories) {
		super();
		this.catId = catId;
		this.catName = catName;
		this.parentId = parentId;
		this.categories = categories;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Category [catId=" + catId + ", catName=" + catName + ", parentId=" + parentId + ", categories="
				+ categories + "]";
	}	
}
