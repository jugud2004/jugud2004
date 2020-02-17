package com.communication.stock.messages.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.communication.stock.messages.MessagesVO;

public class MessagesRowMapper implements RowMapper<MessagesVO> {

	@Override
	public MessagesVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MessagesVO vo = new MessagesVO();
		vo.setContents1(rs.getString("contents1"));
		vo.setCheck1(rs.getInt("check1"));
		vo.setOwnerShip(rs.getString("ownerShip"));
		vo.setMsCount(rs.getInt("msCount"));
		return vo;
	}

}
