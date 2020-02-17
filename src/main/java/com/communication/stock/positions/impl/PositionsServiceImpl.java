package com.communication.stock.positions.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.stock.positions.PositionsService;
import com.communication.stock.positions.PositionsVO;

@Service
public class PositionsServiceImpl implements PositionsService{
	
	@Autowired
	PositionsDAO dao;
	
	@Override
	public List<PositionsVO> getPositionsAll() {
		return dao.getPositionsAll();
	}

}
