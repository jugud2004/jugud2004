package com.communication.stock.militaryInfo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.communication.stock.militaryInfo.MilitaryInfoVO;

@Repository
public class MilitaryInfoDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public MilitaryInfoVO getMtInfo(MilitaryInfoVO vo) {
		String sql = "select * from militaryInfo where = ?";
		Object[] args = {vo.getMtCode()};
		return jdbcTemplate.queryForObject(sql, args, new MtInfoRowMapper());
	}
	
	public List<MilitaryInfoVO> getMtInfoAll(){
		String sql = "select * from militaryInfo";
		return jdbcTemplate.query(sql, new MtInfoRowMapper());
	}
	
}
