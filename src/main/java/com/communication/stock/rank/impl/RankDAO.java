package com.communication.stock.rank.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.communication.stock.rank.RankVO;

@Repository
public class RankDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<RankVO> getRankAll() {
		String sql = "select * from rank order by rankCode asc";
		return jdbcTemplate.query(sql, new RankRowMapper());
	}

}
