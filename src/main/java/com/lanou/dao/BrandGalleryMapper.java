package com.lanou.dao;

import org.springframework.stereotype.Repository;

import com.lanou.entity.Brand;

@Repository
public interface BrandGalleryMapper {
	
	//wz
	public Brand findBrandGalleryById(int brandId);
	
	
	
}
