package com.communication.stock.handlingGrade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.stock.handlingGrade.HandlingGradeService;
import com.communication.stock.handlingGrade.HandlingGradeVO;

@Service
public class HandlingGradeServiceImpl implements HandlingGradeService{
	
	@Autowired
	HandlingGradeDAO dao;
	
	@Override
	public List<HandlingGradeVO> handlingGrade() {
		return dao.handlingGrade();
	}
	
}
