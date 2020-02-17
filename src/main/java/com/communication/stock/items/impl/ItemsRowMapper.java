package com.communication.stock.items.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.communication.stock.items.ItemsVO;

public class ItemsRowMapper implements RowMapper<ItemsVO> {

	@Override
	public ItemsVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ItemsVO vo = new ItemsVO();
		vo.setItemID(rs.getString("itemID"));
		vo.setItemName(rs.getString("itemName"));
		vo.setItemSortation(rs.getString("itemSortation"));
		vo.setItemType(rs.getInt("itemType"));
		vo.setHandlingGrade(rs.getInt("handlingGrade"));
		vo.setSecurityLevel(rs.getInt("securityLevel"));
		vo.setOwnership(rs.getString("ownerShip"));
		return vo;
	}

}
