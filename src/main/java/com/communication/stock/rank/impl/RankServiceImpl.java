package com.communication.stock.rank.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.stock.rank.RankService;
import com.communication.stock.rank.RankVO;

@Service
public class RankServiceImpl implements RankService{
	
	@Autowired
	RankDAO dao;
	
	@Override
	public List<RankVO> getRankAll() {
		return dao.getRankAll();
	}
	
}
