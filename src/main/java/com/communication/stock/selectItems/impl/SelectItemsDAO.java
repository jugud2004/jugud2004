package com.communication.stock.selectItems.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.communication.stock.selectItems.SelectItemsVO;

@Repository
public class SelectItemsDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<SelectItemsVO> itemQuentity(HttpSession session){
		String sql="select * from selectItems where ownerShip='"+session.getAttribute("userId")+"'";
		return jdbcTemplate.query(sql, new SelectItemsRowMapper());
	}
}
