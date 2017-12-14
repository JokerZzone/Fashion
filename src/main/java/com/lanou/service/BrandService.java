package com.lanou.service;

import java.util.List;
import java.util.Map;

import com.lanou.entity.Brand;

public interface BrandService {

	public List<Brand> selectLikeDesc_Letter(String braDesc);
	
	public List<Brand> selectLikeDesc_Country(String braDesc);
	
<<<<<<< HEAD
	public void addBrand(Brand brand);
=======
	//4.商品品牌
	//查看所有品牌信息	
	public Map<String, Object> findAllBrands(int pageId,int pageNumber);
	
	//模糊查询品牌信息
	public Map<String, Object> findLikeBrands(String name,int pageId,int pageNumber);
	
	//添加品牌
	public boolean addBrand(Brand brand);
	
	//修改品牌
	public boolean updateBrand(Brand brand);
	
	//删除品牌
	public boolean deleteBrand(int brandId);
	
>>>>>>> origin/12.12
}
