package com.lanou.entity;

public class Brand {
	
	private Integer braId;
	private String braName;
	private String braImg;
	private String braDesc;
	
	public Integer getBraId() {
		return braId;
	}
	public void setBraId(Integer braId) {
		this.braId = braId;
	}
	public String getBraName() {
		return braName;
	}
	public void setBraName(String braName) {
		this.braName = braName;
	}
	public String getBraImg() {
		return braImg;
	}
	public void setBraImg(String braImg) {
		this.braImg = braImg;
	}
	public String getBraDesc() {
		return braDesc;
	}
	public void setBraDesc(String braDesc) {
		this.braDesc = braDesc;
	}
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Brand(String braName, String braImg, String braDesc) {
		super();
		this.braName = braName;
		this.braImg = braImg;
		this.braDesc = braDesc;
	}
	@Override
	public String toString() {
		return "Brand [braId=" + braId + ", braName=" + braName + ", braImg=" + braImg + ", braDesc=" + braDesc + "]";
	}
	
	

}
