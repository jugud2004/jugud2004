package com.communication.stock.security.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.stock.security.SecurityService;
import com.communication.stock.security.SecurityVO;

@Service
public class SecurityServiceImpl implements SecurityService{

	@Autowired
	SecurityDAO dao;
	
	@Override
	public List<SecurityVO> security() {
		return dao.security();
	}

}
