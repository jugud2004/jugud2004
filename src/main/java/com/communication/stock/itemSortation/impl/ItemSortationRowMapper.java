package com.communication.stock.itemSortation.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.communication.stock.itemSortation.ItemSortationVO;

public class ItemSortationRowMapper implements RowMapper<ItemSortationVO>{

	@Override
	public ItemSortationVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ItemSortationVO vo = new ItemSortationVO();
		vo.setItemSortation(rs.getString("itemSortation"));
		vo.setItemSortationName(rs.getString("itemSortationName"));
		return vo;
	}

}
