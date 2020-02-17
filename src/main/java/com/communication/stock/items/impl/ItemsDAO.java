package com.communication.stock.items.impl;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.communication.stock.board.impl.BoardRowMapper;
import com.communication.stock.items.ItemsVO;

@Repository
public class ItemsDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public ItemsVO getItems(ItemsVO vo) {
		String sql = "select * from items where itemID = ?";
		Object[] args = {vo.getItemID()};
		return jdbcTemplate.queryForObject(sql, args, new ItemsRowMapper());
	}
	
	public List<ItemsVO> getItemsAll(HttpSession session){
		String sql = "select * from items where ownership='"+session.getAttribute("userId")+"' order by itemID asc";
		return jdbcTemplate.query(sql, new ItemsRowMapper());
	}
	
	public void insertItems(ItemsVO vo,HttpSession session) {
		String sql = "insert into items values(itemSortation"+vo.getItemSortation()+".nextval, ?, ?, ?, ?, ?,?)";
		jdbcTemplate.update(sql, vo.getItemName(), vo.getItemSortation(), vo.getItemType(),
				vo.getHandlingGrade(), vo.getSecurityLevel(),session.getAttribute("userId"));
	}
	
	public void deleteItems(ItemsVO vo) {
		String sql = "delete from items where itemID = ?";
		jdbcTemplate.update(sql, vo.getItemID());
	}

	public List<ItemsVO> getItemsAllSort(String sql) {
		return jdbcTemplate.query(sql, new ItemsRowMapper());
	}
	/*여수 밤바다아아아아 이조명에 담긴 아름다운 얘기가 있어*/
	public void releaseItem(ItemsVO vo) {
		String sql = "update items set ownerShip = ? where itemid = ?";
		jdbcTemplate.update(sql, vo.getOwnership(),vo.getItemID());
	}

	public List<ItemsVO> itemsSearchInfo(String sql) {
		return jdbcTemplate.query(sql, new ItemsRowMapper());
	}
	
	public void updateItems(ItemsVO vo) {
		String sql = "update items set itemName=?, itemSortation=?, itemType=?, handlingGrade=?, securityLevel=? where itemId=?";
		jdbcTemplate.update(sql, vo.getItemName(),vo.getItemSortation(),vo.getItemType(),vo.getHandlingGrade(),vo.getSecurityLevel(),vo.getItemID());
	}
}
