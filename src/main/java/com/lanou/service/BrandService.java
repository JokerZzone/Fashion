package com.lanou.service;

import java.util.List;

import com.lanou.entity.Brand;

public interface BrandService {

	public List<Brand> selectLikeDesc_Letter(String braDesc);
	
	public List<Brand> selectLikeDesc_Country(String braDesc);
	
	public void addBrand(Brand brand);
}
