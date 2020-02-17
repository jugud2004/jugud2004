package com.communication.stock.itemSortation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.communication.stock.itemSortation.ItemSortationVO;

@Repository
public class ItemSortationDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<ItemSortationVO> itemSortation(){
		String sql = "select * from itemSortationTB order by itemSortation asc";
		return jdbcTemplate.query(sql, new ItemSortationRowMapper());
	}
	
}
