package com.communication.stock.users.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.communication.stock.users.UsersVO;

public class UsersRowMapper implements RowMapper<UsersVO> {

	@Override
	public UsersVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UsersVO vo = new UsersVO();
		vo.setId(rs.getString("id"));
		vo.setName(rs.getString("name"));
		vo.setPassword(rs.getString("password"));
		vo.setRankCode(rs.getInt("rankCode"));
		vo.setPositionCode(rs.getInt("positionCode"));
		vo.setMtCode(rs.getLong("mtCode"));
		return vo;
	}

}
