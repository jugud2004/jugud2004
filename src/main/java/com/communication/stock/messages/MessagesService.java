package com.communication.stock.messages;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.communication.stock.users.UsersVO;

public interface MessagesService {
	List<MessagesVO> allMessages(UsersVO vo);
	
	void insertMessages(MessagesVO vo);
	
	void updateMessages(UsersVO vo);
	
	void deleteMessages(MessagesVO vo, HttpServletRequest request);

	List<MessagesVO> notReadAllMessages(UsersVO vo);
}
