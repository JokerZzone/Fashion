package com.lanou.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lanou.entity.Collections;

public interface CollectionMapper {

	public List<Collections> findCollectionByUId(int user_id,int startPos,int nowPage);
	
	public void addCollection(
		@Param("user_id") int user_id,
		@Param("goods_id") int goods_id,
		@Param("add_time") Date add_time
	);
	public int getCountOfCollection(int user_id);
	
	public void deleteCollectionById(
			@Param("user_id") int user_id,
			@Param("array") int[] goods_ids
		);
	
	public void deleteAllCollection(int user_id);
	
}
