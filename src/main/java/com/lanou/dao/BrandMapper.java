package com.lanou.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lanou.entity.Brand;

@Repository
public interface BrandMapper {
	
	public Brand findBrandById(int brand);
	
	public List<Brand> selectLikeDesc_Letter(String braDesc);
	
	public List<Brand> selectLikeDesc_Country(String braDesc);
	
	public void addBrand(Brand brand);
	
}
