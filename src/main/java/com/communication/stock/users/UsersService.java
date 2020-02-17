package com.communication.stock.users;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.communication.stock.militaryInfo.MilitaryInfoVO;

public interface UsersService {
	String getUsers(UsersVO vo,HttpSession session);
	
	List<UsersVO> getUsersAll();
	
	void deleteUser(UsersVO vo);

	void joinUsers(UsersVO vo, HttpServletRequest request);
	
	void updateUsers(UsersVO vo, HttpServletRequest request);
}
