package com.lanou.dao;

import java.util.List;

import com.lanou.entity.Brand;

public interface BrandMapper {
	
	public List<Brand> selectLikeDesc_Letter(String braDesc);
	
	public List<Brand> selectLikeDesc_Country(String braDesc);
	
}
