package com.lanou.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lanou.entity.Category;

@Repository
public interface CategoryMapper {
//  展示所有数据
	//无限极查询
	//根据主键查询每条分类信息
	public Category selectByPrimaryKey(Integer primaryKey);
	//1.先发送一个一级分类
	public List<Category> findFatherCategory();
	public List<Category> findSimpleFatherCategory();
	//商品标签(二级分类名称)
	public List<Category> selectCategoryChildrenByParentId(Integer parentId);
	//2.显示子分类

	
}
