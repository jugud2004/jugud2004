package com.communication.stock.board.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.communication.stock.board.BoardService;
import com.communication.stock.board.BoardVO;

@Repository
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDAO dao;

	@Override
	public BoardVO getBoard(BoardVO vo, HttpSession session) {
		return dao.getBoard(vo, session);
	}

	@Override
	public List<BoardVO> getBoardAll(BoardVO vo, HttpSession session) {
		session.setAttribute("classify", vo.getClassify());
		return dao.getBoardAll(vo);
	}

	@Override
	public String insertBoard(BoardVO vo, HttpSession session,HttpServletRequest request) {
		vo.setClassify((Integer) session.getAttribute("classify"));
		String fileName = ""+vo.getUploadFile();
		dao.insertBoard(vo, session, fileName);
		
		return "board.do?classify="+vo.getClassify();
	}

	@Override
	public void deleteBoard(BoardVO vo, HttpSession session) {
		dao.deleteBoard(vo, session);
	}

	@Override
	public String updateBoard(BoardVO vo, HttpSession session) {
		vo.setClassify((Integer)session.getAttribute("classify"));
		dao.updateBoard(vo, session);
		return "getBoard.do";
	}

	@Override
	public void getBoardCount(int seq) {
		dao.getBoardCount(seq);
	}

	@Override
	public String addressInfo(BoardVO vo, HttpSession session) {//List 목록 후 넘겨줄 주소를 연산하여 뿌려줌
		if(vo.getClassify()==0) {
			return "board0.jsp";
		}else if(vo.getClassify()==1) {
			return "board1.jsp";
		}else {
			return "board2.jsp";
		}
	}
	
	@Override
	public List<BoardVO> searchBoardAll(BoardVO vo, HttpSession session,HttpServletRequest request) {//검색
		session.setAttribute("classify", vo.getClassify());
		System.out.println(vo.getClassify());
		String searchType = request.getParameter("searchType");
		String searchContent = request.getParameter("seachContent");
		return dao.searchBoardAll(vo,searchType,searchContent);
	}
	
}
