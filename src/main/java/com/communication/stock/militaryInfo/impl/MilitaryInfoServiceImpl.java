package com.communication.stock.militaryInfo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.stock.militaryInfo.MilitaryInfoService;
import com.communication.stock.militaryInfo.MilitaryInfoVO;

@Service
public class MilitaryInfoServiceImpl implements MilitaryInfoService{
	
	@Autowired
	MilitaryInfoDAO dao;

	@Override
	public MilitaryInfoVO getMtInfo(MilitaryInfoVO vo) {
		return dao.getMtInfo(vo);
	}

	@Override
	public List<MilitaryInfoVO> getMtInfoAll() {
		return dao.getMtInfoAll();
	}
}
