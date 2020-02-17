package com.communication.stock.security.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.communication.stock.security.SecurityVO;

@Repository
public class SecurityDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<SecurityVO> security(){
		String sql = "select * from security order by SECURITYLEVEL asc";
		return jdbcTemplate.query(sql, new SecurityRowMapper());
	}
}
