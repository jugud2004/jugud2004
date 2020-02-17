package com.communication.stock.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface BoardService {
	BoardVO getBoard(BoardVO vo, HttpSession session);
	
	List<BoardVO> getBoardAll(BoardVO vo, HttpSession session);
	
	String insertBoard(BoardVO vo, HttpSession session,HttpServletRequest request);
	
	void deleteBoard(BoardVO vo, HttpSession session);
	
	String updateBoard(BoardVO vo, HttpSession session);
	
	void getBoardCount(int seq);
	
	String addressInfo(BoardVO vo, HttpSession session);
	
	public List<BoardVO> searchBoardAll(BoardVO vo, HttpSession session,HttpServletRequest request);//검색

}
