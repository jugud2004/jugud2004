package com.communication.stock.users.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.communication.stock.selectItems.SelectItemsVO;
import com.communication.stock.selectItems.impl.SelectItemsRowMapper;
import com.communication.stock.users.UsersVO;

@Repository
public class UsersDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UsersVO getUsers(UsersVO vo) {
		String sql = "select * from users where id = ?";
		Object[] args = {vo.getId()};
		System.out.println(vo.getId());
		try {
			return jdbcTemplate.queryForObject(sql, args, new UsersRowMapper());
		}catch (Exception e) {
			return null;
		}
		
		
	}
	
	public List<UsersVO> getUsersAll(){
		String sql = "select * from users";
		return jdbcTemplate.query(sql, new UsersRowMapper());
	}

	public void deleteUser(UsersVO vo) {
		String sql = "delete from users where id = ?";
		jdbcTemplate.update(sql,vo.getId());
	}
	
	public void joinUsers(UsersVO vo,String command, String corps, String division, String regiment, String battalion, String company, String platoon) {
		String sql = "insert into users values(?, ?, ?, ?, ?, (select MTCODE from militaryinfo where command "+command+" and corps "+corps+" and division "+division+" and REGIMENT "+regiment+" and BATTALION "+battalion+" and COMPANY "+company+" and PLATOON "+platoon+"))";
		jdbcTemplate.update(sql, vo.getId(), vo.getName(), vo.getPassword(), vo.getRankCode(),
				vo.getPositionCode());
	}
	
	
	public void updateUsers(UsersVO vo) {
		String sql = "update users set name=?, rankCode=?,PositionCode=?,mtCode=? where id=?";
		jdbcTemplate.update(sql,vo.getName(),vo.getRankCode(),vo.getPositionCode(),vo.getMtCode(),vo.getId());
		
	}
	
	
}
