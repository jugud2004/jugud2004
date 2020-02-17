package com.communication.stock.usersInfo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.communication.stock.usersInfo.UsersInfoVO;

public class UsersInfoRowMapper implements RowMapper<UsersInfoVO> {

	
	@Override
	public UsersInfoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UsersInfoVO vo = new UsersInfoVO();
		vo.setId(rs.getString("id"));
		vo.setName(rs.getString("name"));
		vo.setRankName(rs.getString("rankName"));
		vo.setPositionName(rs.getString("positionName"));
		vo.setMtCode(rs.getLong("mtCode"));
		vo.setCommand(rs.getInt("command"));
		vo.setCorps(rs.getInt("corps"));
		vo.setDivision(rs.getInt("division"));
		vo.setRegiment(rs.getInt("regiment"));
		vo.setBattalion(rs.getInt("battalion"));
		vo.setCompany(rs.getInt("company"));
		vo.setPlatoon(rs.getInt("platoon"));
		return vo;
	}

}
