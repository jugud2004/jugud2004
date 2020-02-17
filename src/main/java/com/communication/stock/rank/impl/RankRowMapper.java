package com.communication.stock.rank.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.communication.stock.rank.RankVO;

public class RankRowMapper implements RowMapper<RankVO>{

	@Override
	public RankVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		RankVO vo = new RankVO();
		vo.setRankCode(rs.getInt("rankCode"));
		vo.setRankName(rs.getString("rankName"));
		return vo;
	}

}
