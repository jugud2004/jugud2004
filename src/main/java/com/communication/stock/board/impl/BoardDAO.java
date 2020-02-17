package com.communication.stock.board.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.communication.stock.board.BoardVO;

@Repository
public class BoardDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public BoardVO getBoard(BoardVO vo, HttpSession session) {
		String sql = "select * from board where seq = ?";
		Object[] args = {vo.getSeq()};
		getBoardCount(vo.getSeq());
		return (BoardVO) jdbcTemplate.queryForObject(sql, args, new BoardRowMapper());
	}
	
	public List<BoardVO> getBoardAll(BoardVO vo){
		String sql = "select * from board where classify="+ vo.getClassify() +" order by seq asc";
		return jdbcTemplate.query(sql, new BoardRowMapper());
	}
	
	public void insertBoard(BoardVO vo, HttpSession session,String fileName) {
		String sql = "insert into board values(boardseq.nextval, ?, ?, ?, sysdate, 0, ?,?)";
		jdbcTemplate.update(sql, vo.getTitle(), vo.getClassify(), vo.getContent(), session.getAttribute("userId"), fileName);
	}
	
	public void deleteBoard(BoardVO vo, HttpSession session) {
		String sql = "delete from board where seq = ?";
		jdbcTemplate.update(sql, vo.getSeq());
	}
	
	public void updateBoard(BoardVO vo, HttpSession session) {
		String sql = "update board set title = ?, classify = ?, content = ? , writer = ? where seq = ?";
		jdbcTemplate.update(sql, vo.getTitle(), vo.getClassify(), vo.getContent(),session.getAttribute("userId"), vo.getSeq());
	}
	
	public void getBoardCount(int seq) {
		String sql = "update board set viewCount = viewCount+1 where seq = ?";
		jdbcTemplate.update(sql, seq);
	}
	
	public List<BoardVO> searchBoardAll(BoardVO vo,String searchType,String searchContent){//검색 리스트
		String sql = "select * from board where classify="+vo.getClassify()+" and "+searchType+" like '%"+searchContent+"%' order by seq asc";
		return jdbcTemplate.query(sql, new BoardRowMapper());
	}
}
