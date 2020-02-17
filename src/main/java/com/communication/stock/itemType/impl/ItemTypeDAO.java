package com.communication.stock.itemType.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.communication.stock.itemType.ItemTypeVO;

@Repository
public class ItemTypeDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ItemTypeVO> itemTypeAll(){
		String sql = "select * from itemTypeTB";
		return jdbcTemplate.query(sql, new ItemTypeRowMapper());
	}
}
