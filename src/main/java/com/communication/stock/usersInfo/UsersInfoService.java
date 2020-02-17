package com.communication.stock.usersInfo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


public interface UsersInfoService {
	
	List<UsersInfoVO> getUsersInfoAll();
	
	List<UsersInfoVO> usersSearchList(HttpServletRequest request);

}
