package com.communication.stock.items;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.communication.stock.messages.MessagesVO;

public interface ItemsService {
	ItemsVO getItems(ItemsVO vo);
	
	List<ItemsVO> getItemsAll(HttpSession session);
	
	void insertItems(ItemsVO vo,HttpSession session);
	
	void deleteItems(ItemsVO vo,HttpServletRequest request);
	
	List<ItemsVO> getItemsAllSort(HttpSession session,HttpServletRequest request);
//	void updateItems(ItemsVO vo);
	
	public String itemRelease_proc(ItemsVO vo, HttpSession session,HttpServletRequest request,MessagesVO msVo);
	
	List<ItemsVO> itemsSearchInfoTest(HttpServletRequest request);
	
	public void updateItems(ItemsVO vo,HttpServletRequest request);
}
