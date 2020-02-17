package com.communication.stock.itemType.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.communication.stock.itemType.ItemTypeVO;

public class ItemTypeRowMapper implements RowMapper<ItemTypeVO> {

	@Override
	public ItemTypeVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ItemTypeVO vo = new ItemTypeVO();
		vo.setItemType(rs.getInt("itemType"));
		vo.setItemTypeName(rs.getString("itemTypeName"));
		return vo;
	}

}
