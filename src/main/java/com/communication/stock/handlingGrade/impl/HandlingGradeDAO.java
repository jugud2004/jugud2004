package com.communication.stock.handlingGrade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.communication.stock.handlingGrade.HandlingGradeVO;
@Repository
public class HandlingGradeDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<HandlingGradeVO> handlingGrade(){
		String sql = "select * from handlingGradetb order by handlingGrade asc";
		return jdbcTemplate.query(sql, new HandlingGradeRowMapper());
	}
}
