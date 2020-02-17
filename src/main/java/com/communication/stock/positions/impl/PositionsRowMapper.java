package com.communication.stock.positions.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.communication.stock.positions.PositionsVO;

public class PositionsRowMapper implements RowMapper<PositionsVO>{

	@Override
	public PositionsVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PositionsVO vo = new PositionsVO();
		vo.setPositionCode(rs.getInt("positionCode"));
		vo.setPositionName(rs.getString("positionName"));
		return vo;
	}
	
}
