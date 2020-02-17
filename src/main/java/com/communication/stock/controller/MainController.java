package com.communication.stock.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.communication.stock.board.BoardService;
import com.communication.stock.board.BoardVO;
import com.communication.stock.handlingGrade.HandlingGradeService;
import com.communication.stock.itemSortation.ItemSortationService;
import com.communication.stock.itemSortation.ItemSortationVO;
import com.communication.stock.itemType.ItemTypeService;
import com.communication.stock.items.ItemsService;
import com.communication.stock.items.ItemsVO;
import com.communication.stock.messages.MessagesService;
import com.communication.stock.messages.MessagesVO;
import com.communication.stock.security.SecurityService;
import com.communication.stock.selectItems.SelectItemsService;
import com.communication.stock.users.UsersService;
import com.communication.stock.users.UsersVO;


@Controller
public class MainController {
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	ItemsService itemsService;
	
	@Autowired
	ItemSortationService itemSortationService;
	
	@Autowired
	SelectItemsService selectItemsService;
	
	@Autowired
	ItemTypeService itemTypeService;
	
	@Autowired
	HandlingGradeService handlingGradeService;
	
	@Autowired
	SecurityService securityService;
	
	@Autowired
	MessagesService messagesService;

////=========================================================================================================	
	
	@RequestMapping("menu.do")
	public ModelAndView menu(ModelAndView mav,HttpSession session,UsersVO vo) {
		System.out.println("[메인화면] - 메뉴");
		vo.setId((String)session.getAttribute("userId"));
		mav.addObject("messages",messagesService.notReadAllMessages(vo));
		mav.setViewName("menu.jsp");
		//추후 알림 기능 추가 시 알림 테이블에 로그인 시 사용한 아이디에 해당되는 알림을 리스트로 조회 후
		//	프론트에서 해당 list를 count 하여 알림 갯수를 띄워 주고, 클릭시 알림 내용을 뿌려준다.
		return mav;
	}
	
	@RequestMapping("main.do")
	public ModelAndView mainScreen(ModelAndView mav,HttpSession session,UsersVO vo, BoardVO vo2) {
		System.out.println("[메인화면]");
		if(session == null||session.getAttribute("userId")==null) {
			mav.setViewName("login.do");
			return mav;
		}
		vo.setId((String)session.getAttribute("userId"));
		mav.addObject("bdList", boardService.getBoardAll(vo2, session));
		mav.addObject("messages",messagesService.notReadAllMessages(vo));
		mav.setViewName("main.jsp");
		//추후 알림 기능 추가 시 알림 테이블에 로그인 시 사용한 아이디에 해당되는 알림을 리스트로 조회 후
		//	프론트에서 해당 list를 count 하여 알림 갯수를 띄워 주고, 클릭시 알림 내용을 뿌려준다.
		return mav;
	}
	
	@RequestMapping("messageList.do")
	public ModelAndView messageScreen(ModelAndView mav,HttpSession session,UsersVO vo) {
		System.out.println("[알림화면]");
		vo.setId((String)session.getAttribute("userId"));
		mav.addObject("messagesList",messagesService.allMessages(vo));
		messagesService.updateMessages(vo);
		mav.setViewName("messageList.jsp");
		//추후 알림 기능 추가 시 알림 테이블에 로그인 시 사용한 아이디에 해당되는 알림을 리스트로 조회 후
		//	프론트에서 해당 list를 count 하여 알림 갯수를 띄워 주고, 클릭시 알림 내용을 뿌려준다.
		return mav;
	}
	
	@RequestMapping("deleteMessage.do")
	public String deleteMessage(ModelAndView mav,HttpSession session,MessagesVO vo,HttpServletRequest request) {
		System.out.println("[알림화면] - 삭제");
		messagesService.deleteMessages(vo,request);
		return "messageList.do";
	}

////=================================================[게시판]==================================================
	
	@RequestMapping("board.do")//게시판 리스트
	public ModelAndView getBoardAll(ModelAndView mav, HttpSession session,BoardVO vo) {
		System.out.println("[게시판]");
		if(session == null||session.getAttribute("userId")==null) {
			mav.setViewName("login.do");
			return mav;
		}
		
		
		mav.addObject("boardList", boardService.getBoardAll(vo, session));
		mav.setViewName(boardService.addressInfo(vo, session));
		
		return mav;
	}
	
	@RequestMapping("searchBoard.do")//게시판 검색 리스트
	public ModelAndView searchBoard(ModelAndView mav, HttpSession session,BoardVO vo,HttpServletRequest request) {
		System.out.println("[게시판 - 검색]");
		if(session == null||session.getAttribute("userId")==null) {
			mav.setViewName("login.do");
			return mav;
		}
		mav.addObject("boardList", boardService.searchBoardAll(vo, session, request));
		mav.setViewName(boardService.addressInfo(vo, session));
		
		return mav;
	}
	
	@RequestMapping("getBoard.do")//게시판 상세보기
	public ModelAndView getBoard(BoardVO vo, ModelAndView mav, HttpSession session) {
		System.out.println("[게시판 상세보기]");
		if(session == null||session.getAttribute("userId")==null) {
			mav.setViewName("login.do");
			return mav;
		}
		mav.addObject("board", boardService.getBoard(vo,session));
		mav.setViewName("getBoard.jsp");
		return mav;
	}
	
	@RequestMapping("insertBoard.do")//게시판 글쓰기
	public ModelAndView insertBoard(ModelAndView mav, HttpSession session, BoardVO vo) {
		System.out.println("[게시판 글쓰기]");
		if(session == null||session.getAttribute("userId")==null) {
			mav.setViewName("login.do");
			return mav;
		}
		mav.addObject("vo", vo);
		mav.setViewName("insertBoard.jsp");
		
		return mav;
	}
	
	////////////////////////////////////////////////////////
	
	@RequestMapping("insertBoard_proc.do")//게시판 글쓰기
	public String insertBoard_proc(HttpSession session, BoardVO vo,HttpServletRequest request) throws IOException {
		
		if(session == null||session.getAttribute("userId")==null) {
			return "login.do";
		}
		
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()){
			String fileName =  uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("D:/" + fileName));
		}
		System.out.println(vo.getUploadFile());
		System.out.println("[게시판 글쓰기-action]");
		System.out.println(session.getAttribute("userId"));//추후 비교문을 이용한 아이디 검사 필요
		
		return boardService.insertBoard(vo,session,request);
		
	}
	
	
	
	////////////////////////////////////////////////////////

	@RequestMapping("updateBoard.do")//게시판 글수정
	public ModelAndView updateBoard(HttpSession session, BoardVO vo, ModelAndView mav) {
		System.out.println("[게시판 글수정]");
		if(session == null||session.getAttribute("userId")==null) {
			mav.setViewName("login.do");
			return mav;
		}
		mav.addObject("board", boardService.getBoard(vo,session));
		mav.setViewName("updateBoard.jsp");

		return mav;
	}
	
	@RequestMapping("updateBoard_proc.do")//게시판 글수정 action 
	public String updateBoard_proc(HttpSession session, BoardVO vo) {
		if(session == null||session.getAttribute("userId")==null) {
			return "login.do";
		}
		System.out.println("[게시판 글수정 - action]");
		return boardService.updateBoard(vo,session);
	}
	
	@RequestMapping("deleteBoard.do")//게시판 삭제
	public String deleteBoard(HttpSession session, BoardVO vo) {
		if(session == null||session.getAttribute("userId")==null) {
			return "login.do";
		}
		System.out.println("[게시판 삭제]");
		boardService.deleteBoard(vo, session);
		System.out.println(vo);
		return "board.do?classify="+session.getAttribute("classify");
	}
	
////===========================================[재고 관련]================================================	
	
	@RequestMapping("itemsInfoTest.do")//재고 리스트
	public ModelAndView mainScreen(ModelAndView mav, HttpSession session,ItemsVO vo) {
		System.out.println("[재고화면]");
		if(session == null||session.getAttribute("userId")==null) {
			mav.setViewName("login.do");
			return mav;
		}
		System.out.println(session.getAttribute("userId"));//추후 비교문을 이용한 아이디 검사 필요
		mav.addObject("itemInfo", itemsService.getItemsAll(session));
		mav.addObject("itemQuentity",selectItemsService.itemQuentity(session));
		mav.setViewName("itemsInfoTest.jsp");
		return mav;
	}
	
	@RequestMapping("itemsSearchInfoTest.do")//재고 검색 리스트
	public ModelAndView itemsSearchInfoTest(ModelAndView mav, HttpSession session,ItemsVO vo,HttpServletRequest request) {
		System.out.println("[재고 검색 화면]");
		if(session == null||session.getAttribute("userId")==null) {
			mav.setViewName("login.do");
			return mav;
		}
		System.out.println(session.getAttribute("userId"));//추후 비교문을 이용한 아이디 검사 필요
		mav.addObject("itemInfo", itemsService.itemsSearchInfoTest(request));
		mav.addObject("itemQuentity",selectItemsService.itemQuentity(session));
		mav.setViewName("itemsInfoTest.jsp");
		return mav;
	}
	
	@RequestMapping("itemDeleteList.do")//재고 삭제 리스트
	public ModelAndView itemDeleteList(ModelAndView mav, HttpSession session,ItemsVO vo) {
		System.out.println("[재고 삭제 화면]");
		if(session == null||session.getAttribute("userId")==null) {
			mav.setViewName("login.do");
			return mav;
		}
		System.out.println(session.getAttribute("userId"));//추후 비교문을 이용한 아이디 검사 필요
		mav.addObject("itemInfo", itemsService.getItemsAll(session));
		mav.addObject("itemQuentity",selectItemsService.itemQuentity(session));
		mav.setViewName("itemDelete.jsp");
		return mav;
	}
	
	
	@RequestMapping("itemReleaseList.do")//재고 출고 리스트
	public ModelAndView itemReleaseList(ModelAndView mav, HttpSession session,ItemsVO vo) {
		System.out.println("[재고 출고 화면]");
		if(session == null||session.getAttribute("userId")==null) {
			mav.setViewName("login.do");
			return mav;
		}
		System.out.println(session.getAttribute("userId"));//추후 비교문을 이용한 아이디 검사 필요
		mav.addObject("itemInfo", itemsService.getItemsAll(session));
		mav.addObject("itemQuentity",selectItemsService.itemQuentity(session));
		mav.setViewName("itemRelease.jsp");
		return mav;
	}
	
	@RequestMapping("itemsUpdateList.do")//재고 수정 리스트
	public ModelAndView itemsUpdateList(ModelAndView mav, HttpSession session,ItemsVO vo) {
		System.out.println("[재고 수정 화면]");
		if(session == null||session.getAttribute("userId")==null) {
			mav.setViewName("login.do");
			return mav;
		}
		System.out.println(session.getAttribute("userId"));//추후 비교문을 이용한 아이디 검사 필요
		mav.addObject("itemInfo", itemsService.getItemsAll(session));
		mav.addObject("itemQuentity",selectItemsService.itemQuentity(session));
		mav.addObject("sort",itemSortationService.itemSortation());
		mav.addObject("itemType",itemTypeService.itemTypeAll());
		mav.addObject("handlingGrade", handlingGradeService.handlingGrade());
		mav.addObject("security", securityService.security());
		mav.setViewName("itemsUpdate.jsp");
		return mav;
	}
	
	@RequestMapping("itemsUpdateList_proc.do")//재고 수정 리스트
	public String itemsUpdateList(HttpSession session,ItemsVO vo,HttpServletRequest request) {
		System.out.println("[재고 수정 화면 - action]");
		if(session == null||session.getAttribute("userId")==null) {
			return "login.do";
		}
		itemsService.updateItems(vo, request);
		return "itemsUpdateList.do";
	}
	
	@RequestMapping("itemsInfoTest_proc.do")//재고 정렬 실행
	public ModelAndView mainScreen_proc(ModelAndView mav, HttpSession session,ItemsVO vo,HttpServletRequest request) {
		System.out.println("[재고화면 - 정렬]");
		if(session == null||session.getAttribute("userId")==null) {
			mav.setViewName("login.do");
			return mav;
		}
		System.out.println(session.getAttribute("userId"));//추후 비교문을 이용한 아이디 검사 필요
		mav.addObject("itemInfo", itemsService.getItemsAllSort(session,request));
		mav.addObject("itemQuentity",selectItemsService.itemQuentity(session));
		mav.setViewName("itemsInfoTest.jsp");
		return mav;
	}
	
	
	@RequestMapping("itemsInsert.do")//재고 입력
	public ModelAndView insertItems(ItemsVO vo, ModelAndView mav, HttpSession session) {
		System.out.println("[재고 입력]");
		if(session == null||session.getAttribute("userId")==null) {
			mav.setViewName("login.do");
			return mav;
		}
		mav.addObject("sort",itemSortationService.itemSortation());
		mav.addObject("itemType",itemTypeService.itemTypeAll());
		mav.addObject("handlingGrade", handlingGradeService.handlingGrade());
		mav.addObject("security", securityService.security());
		mav.setViewName("itemsInsert.jsp");
		return mav;
	}
	
	@RequestMapping("itemsInsert_proc.do")//재고 입력 action
	public String itemsInsert_proc(ItemsVO vo1, HttpSession session,ItemSortationVO vo2) {
		System.out.println("[재고 입력 완료]");
		if(session == null||session.getAttribute("userId")==null) {
			return "login.do";
		}
		vo1.setItemSortation(vo2.getItemSortation());
		itemsService.insertItems(vo1,session);
		return "itemsInfoTest.do";
	}
	
	@RequestMapping("deleteItem.do")//재고 삭제
	public String deleteBoard(ItemsVO vo, HttpSession session,HttpServletRequest request) {
		System.out.println("[재고 삭제- action]");
		if(session == null||session.getAttribute("userId")==null) {
			return "login.do";
		}
		itemsService.deleteItems(vo,request);
		return "itemDeleteList.do";
	}	
	
	@RequestMapping("itemRelease_proc.do")//재고 삭제
	public String itemRelease_proc(ItemsVO vo, HttpSession session,HttpServletRequest request,MessagesVO msVo) {
		System.out.println("[출고 실행]");
		if(session == null||session.getAttribute("userId")==null) {
			return "login.do";
		}
		return itemsService.itemRelease_proc(vo, session, request,msVo);
	}	

	
	
	
}
