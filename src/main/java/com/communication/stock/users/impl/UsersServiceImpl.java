package com.communication.stock.users.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.stock.users.UsersService;
import com.communication.stock.users.UsersVO;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersDAO dao;
	
	@Override
	public String getUsers(UsersVO vo,HttpSession session) {
		UsersVO user = dao.getUsers(vo);
		System.out.println("로그인(userImpl-getUsers) : " + user);
		if(user==null) {
			return "login.jsp";
		}else if(user.getId().equals(vo.getId())&&user.getPassword().equals(vo.getPassword())) {
			session.setAttribute("userId", user.getId());
			session.setAttribute("position", user.getPositionCode());
			session.setAttribute("userName", user.getName());
			return "main.do";
		}else {
			return "login.jsp";
		}
	}

	@Override
	public List<UsersVO> getUsersAll() {
		return dao.getUsersAll();
	}

	@Override
	public void deleteUser(UsersVO vo) {
		
		dao.deleteUser(vo);
	}
	
	@Override
	public void joinUsers(UsersVO vo, HttpServletRequest request) {
//		vo2.setCommand(command);
//		vo2.setCorps(corps);
//		vo2.setDivision(division);
//		vo2.setRegiment(regiment);
//		vo2.setBattalion(battalion);
//		vo2.setCompany(company);
//		vo2.setPlatoon(platoon);
		vo.setPositionCode(Integer.parseInt(request.getParameter("positions")));
		vo.setRankCode(Integer.parseInt(request.getParameter("rank")));
		String command =(String)request.getParameter("command");
		String corps =(String)request.getParameter("corps");
		String division =(String)request.getParameter("division");
		String regiment =(String)request.getParameter("regiment");
		String battalion =(String)request.getParameter("battalion");
		String company =(String)request.getParameter("company");
		String platoon =(String)request.getParameter("platoon");
		System.out.println(command);
		System.out.println("asgsadG"+request.getParameter("command"));
		if(command.equals("0")) {
			command = "is null";
		}else {
			command = "=" + command;
		}
		
		if(corps.equals("0")) {
			corps = "is null";
		}else {
			corps = "=" + corps;
		}
		
		if(division.equals("0")) {
			division = "is null";
		}else {
			division = "=" + division;
		}
		
		if(regiment.equals("0")) {
			regiment = "is null";
		}else {
			regiment = "=" + regiment;
		}
		
		if(battalion.equals("0")) {
			battalion = "is null";
		}else {
			battalion = "=" + battalion;
		}
		
		if(company.equals("0")) {
			company = "is null";
		}else {
			company = "=" + company;
		}
		
		if(platoon.equals("0")) {
			platoon = "is null";
		}else {
			platoon = "=" + platoon;
		}
		
		
		
		dao.joinUsers(vo,command,corps,division,regiment,battalion,company,platoon);
	}

	@Override
	public void updateUsers(UsersVO vo, HttpServletRequest request) {
		
		vo.setId(request.getParameter("id"));
		vo.setName(request.getParameter("name"));
		vo.setRankCode(Integer.parseInt(request.getParameter("rank")));
		vo.setPositionCode(Integer.parseInt(request.getParameter("positionCode")));
		vo.setMtCode(Long.parseLong(request.getParameter("mtCode")));
		
		dao.updateUsers(vo);
	}

	

}
