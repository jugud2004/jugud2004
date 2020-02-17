package com.communication.stock.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BoardCntRowMapper implements RowMapper<Integer>{

	@Override
	public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
		int listCount = 0;
		listCount = rs.getInt("listCount");
		return listCount;
		
	}

}
