package com.communication.stock.positions.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.communication.stock.positions.PositionsVO;

@Repository
public class PositionsDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<PositionsVO> getPositionsAll(){
		String sql = "select * from positions order by POSITIONCODE asc";
		return jdbcTemplate.query(sql, new PositionsRowMapper());
	}
}
