package com.lanou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lanou.entity.Brand;

@Repository
public interface BrandMapper {
	
	public Brand findBrandById(int brand);
	
	public List<Brand> selectLikeDesc_Letter(String braDesc);
	
	public List<Brand> selectLikeDesc_Country(String braDesc);
	
	//4.商品品牌
	//查看所有品牌信息
	public List<Brand> allBrands(@Param("pageId")int pageId,@Param("pageNumber")int pageNumber);
	
	//获取所有品牌的数量
	public int brandCount();
	
	//模糊查询品牌
	public List<Brand> likeBrands(@Param("name")String name,@Param("pageId")int pageId,@Param("pageNumber")int pageNumber);
	
	//模糊查询品牌的数量
	public int likeBrandsCount();
	
	//添加品牌
	public boolean addBrand(Brand brand);
	
	//编辑品牌
	public boolean updateBrand(Brand brand);
	
	//删除品牌
	public boolean deleteBrand(@Param("brandId")int brandId);
	
	
	
	
	
	
}
