package com.communication.stock.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.communication.stock.board.BoardVO;

public class BoardRowMapper implements RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO vo = new BoardVO();
		vo.setSeq(rs.getInt("seq"));
		vo.setTitle(rs.getString("title"));
		vo.setClassify(rs.getInt("classify"));
		vo.setContent(rs.getString("content"));
		vo.setPostDate(rs.getDate("postDate"));
		vo.setViewCount(rs.getInt("viewCount"));
		vo.setWriter(rs.getString("writer"));
		vo.setFilename(rs.getString("uploadFile"));
		return vo;
	}

}
