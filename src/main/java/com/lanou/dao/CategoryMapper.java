package com.lanou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lanou.entity.Category;

@Repository
public interface CategoryMapper {
	
	//wz
	public Category findByCatId(int catId);
	
	public List<Category> findByParentId(int parentId);
	
	//xy
	public List<Category> findSimpleFatherCategory();
	
	public List<Category> selectCategoryChildrenByParentId(Integer parentId);
	
	//sp
	public int confirmCategoryType(int cat_id);
	
	/**
	 * 卖家
	 */	
	//3.商品分类
	public List<Category> goodsCategory(@Param("pageId")int pageId);
	
	public int categoryTotal();
	
	//商品分类编辑
	public boolean updateCategory(Category category);
	
	//添加商品分类
	public boolean addCategory(Category category);
	
	//根据id获取单个分类
	public Category oneCategory(int catId);

}
