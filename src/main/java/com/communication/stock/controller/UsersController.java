package com.communication.stock.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.communication.stock.militaryInfo.MilitaryInfoService;
import com.communication.stock.militaryInfo.MilitaryInfoVO;
import com.communication.stock.positions.PositionsService;
import com.communication.stock.rank.RankService;
import com.communication.stock.users.UsersService;
import com.communication.stock.users.UsersVO;
import com.communication.stock.usersInfo.UsersInfoService;
import com.communication.stock.usersInfo.UsersInfoVO;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private UsersInfoService usersInfoService;
	
	@Autowired
	private MilitaryInfoService militaryInfoService;
	
	@Autowired
	private PositionsService positionsService;
	
	@Autowired
	private RankService rankService;
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UsersVO vo,HttpSession session) {
		System.out.println("[로그인]");
		return usersService.getUsers(vo,session);
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		System.out.println("[로그인 창으로 이동]");
		return "login.jsp";
		
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login.jsp";
		
	}
	
	@RequestMapping(value="/usersControl.do")
	public ModelAndView usersControl(UsersInfoVO vo,HttpSession session, ModelAndView mav) {
		System.out.println("[인사관리]");
		if(session == null||session.getAttribute("userId")==null) {
			mav.setViewName("login.do");
			return mav;
		}
		mav.addObject("userList", usersInfoService.getUsersInfoAll());//추후 보안 레벨에 따른 권한 확인 기능 추가
		mav.setViewName("usersControl.jsp");
		return mav;
		
	}
	
	@RequestMapping(value="/usersSearchList.do")
	public ModelAndView usersSearchList(UsersInfoVO vo,HttpSession session, ModelAndView mav,HttpServletRequest request) {
		System.out.println("[인사관리-검색]");
		if(session == null||session.getAttribute("userId")==null) {
			mav.setViewName("login.do");
			return mav;
		}
		mav.addObject("userList", usersInfoService.usersSearchList(request));//추후 보안 레벨에 따른 권한 확인 기능 추가
		mav.setViewName("usersControl.jsp");
		return mav;
		
	}
	
	@RequestMapping(value="/deleteUser.do")
	public ModelAndView deleteUser(UsersVO vo,HttpSession session,ModelAndView mav) {
		System.out.println("[인사삭제]");
		if(session == null||session.getAttribute("userId")==null) {
			mav.setViewName("login.do");
			return mav;
		}
		usersService.deleteUser(vo);
		mav.setViewName("usersControl.do");
		return mav;
		
	}
	
	@RequestMapping("joinForm.do")
	public ModelAndView joinUsers(ModelAndView mav) {
		System.out.println("[회원가입]");
		mav.addObject("mtInfo", militaryInfoService.getMtInfoAll());
		mav.addObject("positions", positionsService.getPositionsAll());
		mav.addObject("rank", rankService.getRankAll());
		mav.setViewName("joinForm.jsp");
		return mav;
		
	}
	
	@RequestMapping("joinForm_proc.do")
	public String joinForm_proc(ModelAndView mav, UsersVO vo, HttpServletRequest request) {
		System.out.println("[회원가입-Action]");

		System.out.println(request.getParameter("command"));
		usersService.joinUsers(vo,request);
		return "login.jsp";
		
	}
	
	@RequestMapping(value="/updateUsers.do")
	public ModelAndView updateUsers(ModelAndView mav,UsersVO vo,HttpSession session, HttpServletRequest request) {
		System.out.println("[인사 수정]");
		if(session == null||session.getAttribute("userId")==null) {
			mav.setViewName("login.do");
			return mav;
		}
		mav.addObject("userList",usersInfoService.getUsersInfoAll());
		mav.addObject("positions", positionsService.getPositionsAll());
		mav.addObject("rank", rankService.getRankAll());
		mav.addObject("mtCode",militaryInfoService.getMtInfoAll());
		mav.setViewName("updateUsers.jsp");
		return mav;
		
	}
	
	@RequestMapping(value="/updateUsers_proc.do")
	public ModelAndView updateUsers_proc(ModelAndView mav,UsersVO vo,HttpSession session, HttpServletRequest request) {
		System.out.println("[인사 수정 - action]");
		if(session == null||session.getAttribute("userId")==null) {
			mav.setViewName("login.do");
			return mav;
		}
		usersService.updateUsers(vo, request);
		mav.setViewName("updateUsers.do");
		return mav;
	}
	
}
