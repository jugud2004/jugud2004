package com.communication.stock.militaryInfo.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.communication.stock.militaryInfo.MilitaryInfoVO;

public class MtInfoRowMapper implements RowMapper<MilitaryInfoVO> {
	
	@Autowired
	MilitaryInfoDAO dao;
	
	@Override
	public MilitaryInfoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MilitaryInfoVO vo = new MilitaryInfoVO();
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
