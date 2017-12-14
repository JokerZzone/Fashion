package com.lanou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lanou.dao.NavMapper;
import com.lanou.entity.Nav;
import com.lanou.service.NavService;

@Service("navService")
public class NavServiceImpl implements NavService {

	@Autowired
	private NavMapper navMapper;
	
	@Transactional
	public List<Nav> showAll() {
		return navMapper.selectAll();
	}

	//xy
	@Override
	public List<Nav> showNav() {
		// TODO Auto-generated method stub
		return navMapper.lookNav();
	}

	@Override
	public boolean addNav(Nav nav) {
		// TODO Auto-generated method stub
		return navMapper.addNav(nav);
	}

	@Override
	public boolean updateNav(Nav nav) {
		// TODO Auto-generated method stub
		return navMapper.updateNav(nav);
	}

}
