package com.communication.stock.selectItems.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.communication.stock.selectItems.SelectItemsVO;

public class SelectItemsRowMapper implements RowMapper<SelectItemsVO> {

	@Override
	public SelectItemsVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		SelectItemsVO vo = new SelectItemsVO();
		vo.setItemSortation(rs.getString("itemSortation"));
		vo.setItemQuentity(rs.getInt("itemQuentity"));
		vo.setOwnerShip(rs.getString("ownerShip"));
		return vo;
	}

	

}
