package com.lanou.entity;

public class Nav {

	private int navId;
	
	private String navName;
	
	private String catData;
	
	private int viewOrder;
	
	private int openNew;
	
	private String url;
	
	private String navType;

	public Nav() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNavId() {
		return navId;
	}

	public void setNavId(int navId) {
		this.navId = navId;
	}

	public String getNavName() {
		return navName;
	}

	public void setNavName(String navName) {
		this.navName = navName;
	}

	public String getCatData() {
		return catData;
	}

	public void setCatData(String catData) {
		this.catData = catData;
	}

	public int getViewOrder() {
		return viewOrder;
	}

	public void setViewOrder(int viewOrder) {
		this.viewOrder = viewOrder;
	}

	public int getOpenNew() {
		return openNew;
	}

	public void setOpenNew(int openNew) {
		this.openNew = openNew;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNavType() {
		return navType;
	}

	public void setNavType(String navType) {
		this.navType = navType;
	}
}
