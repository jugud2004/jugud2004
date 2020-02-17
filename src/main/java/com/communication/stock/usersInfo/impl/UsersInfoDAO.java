package com.communication.stock.usersInfo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.communication.stock.usersInfo.UsersInfoVO;

@Repository
public class UsersInfoDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<UsersInfoVO> getUsersInfoAll(){
		String sql = "select * from usersInfo";
		return jdbcTemplate.query(sql, new UsersInfoRowMapper());
	}
	
	public List<UsersInfoVO> usersSearchList(String searchType,String searchContent){
		String sql="select * from usersInfo where "+searchType+"='"+searchContent+"'";
		return jdbcTemplate.query(sql, new UsersInfoRowMapper());
	}
}
