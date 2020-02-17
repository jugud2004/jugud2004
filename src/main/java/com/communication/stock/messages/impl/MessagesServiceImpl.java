package com.communication.stock.messages.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.stock.messages.MessagesService;
import com.communication.stock.messages.MessagesVO;
import com.communication.stock.users.UsersVO;

@Service
public class MessagesServiceImpl implements MessagesService {
	
	@Autowired
	MessagesDAO dao;
	
	public List<MessagesVO> allMessages(UsersVO vo){
		return dao.allMessages(vo);
	}

	@Override
	public void insertMessages(MessagesVO vo) {
		dao.insertMessages(vo);
	}

	@Override
	public void updateMessages(UsersVO vo) {
		dao.updateMessages(vo);
	}

	@Override
	public void deleteMessages(MessagesVO vo,HttpServletRequest request) {
		String[] msCount = request.getParameterValues("msCount");
		for(int i = 0; i < msCount.length; i++) {
			vo.setMsCount(Integer.parseInt(msCount[i]));
			dao.deleteMessages(vo);
		}
	}

	@Override
	public List<MessagesVO> notReadAllMessages(UsersVO vo) {
		return dao.notReadAllMessages(vo);
	}
}
