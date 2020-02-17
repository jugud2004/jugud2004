package com.communication.stock.selectItems.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.stock.selectItems.SelectItemsService;
import com.communication.stock.selectItems.SelectItemsVO;
@Service
public class SelectItemsServiceImpl implements SelectItemsService {
	
	@Autowired
	SelectItemsDAO dao;
	
	
	@Override
	public List<SelectItemsVO> itemQuentity(HttpSession session) {
		return dao.itemQuentity(session);
	}

}
