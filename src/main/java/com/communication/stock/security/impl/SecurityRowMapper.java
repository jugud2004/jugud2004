package com.communication.stock.security.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.communication.stock.security.SecurityVO;

public class SecurityRowMapper implements RowMapper<SecurityVO>{

	@Override
	public SecurityVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		SecurityVO vo = new SecurityVO();
		vo.setSecurityLevel(rs.getInt("securityLevel"));
		vo.setSecurityName(rs.getString("securityName"));
		return vo;
	}

}
