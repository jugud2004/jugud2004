package com.communication.stock.handlingGrade.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.communication.stock.handlingGrade.HandlingGradeVO;

public class HandlingGradeRowMapper implements RowMapper<HandlingGradeVO>{

	@Override
	public HandlingGradeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		HandlingGradeVO vo = new HandlingGradeVO();
		vo.setHandlingGrade(rs.getInt("handlingGrade"));
		vo.setHandlingGradeName(rs.getString("handlingGradeName"));
		return vo;
	}

}
