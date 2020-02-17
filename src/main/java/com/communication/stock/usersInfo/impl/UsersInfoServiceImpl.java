package com.communication.stock.usersInfo.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.stock.usersInfo.UsersInfoService;
import com.communication.stock.usersInfo.UsersInfoVO;

@Service
public class UsersInfoServiceImpl implements UsersInfoService{

	@Autowired
	UsersInfoDAO dao;
	
	@Override
	public List<UsersInfoVO> getUsersInfoAll() {
		return dao.getUsersInfoAll();
	}
	
	@Override
	public List<UsersInfoVO> usersSearchList(HttpServletRequest request) {
		String searchType = request.getParameter("searchType");
		String searchContent = request.getParameter("searchContent");
		return dao.usersSearchList(searchType,searchContent);
	}

}
