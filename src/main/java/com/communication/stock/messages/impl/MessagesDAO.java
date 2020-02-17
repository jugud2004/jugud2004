package com.communication.stock.messages.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.communication.stock.messages.MessagesVO;
import com.communication.stock.users.UsersVO;

@Repository
public class MessagesDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<MessagesVO> allMessages(UsersVO vo){
		String sql = "select * from messages where ownerShip='" + vo.getId()+"' order by msCount asc";
		return jdbcTemplate.query(sql, new MessagesRowMapper());
	}
	
	public List<MessagesVO> notReadAllMessages(UsersVO vo){
		String sql = "select * from messages where ownerShip='" + vo.getId()+"' and check1=0";
		return jdbcTemplate.query(sql, new MessagesRowMapper());
	}
	
	public void insertMessages(MessagesVO vo) {
		String sql = "insert into messages values((select nvl(max(msCount),0)+1 from messages),?,0,?)";
		jdbcTemplate.update(sql,vo.getContents1(),vo.getOwnerShip());
	}
	
	public void updateMessages(UsersVO vo) {
		String sql = "update messages set check1=1 where ownerShip=?";
		jdbcTemplate.update(sql,vo.getId());
	}
	
	public void deleteMessages(MessagesVO vo) {
		String sql = "delete from messages where msCount=?";
		jdbcTemplate.update(sql,vo.getMsCount());
	}
	
}
