package com.communication.stock.items.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.communication.stock.items.ItemsService;
import com.communication.stock.items.ItemsVO;
import com.communication.stock.messages.MessagesService;
import com.communication.stock.messages.MessagesVO;
import com.communication.stock.users.UsersService;
import com.communication.stock.users.UsersVO;

@Service
public class ItemsServiceImpl implements ItemsService{

	@Autowired
	ItemsDAO dao;
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	MessagesService messagesService;
	
	@Override
	public ItemsVO getItems(ItemsVO vo) {
		return dao.getItems(vo);
	}

	@Override
	public List<ItemsVO> getItemsAll(HttpSession session) {
		return dao.getItemsAll(session);
	}

	@Override
	public void insertItems(ItemsVO vo,HttpSession session) {
		dao.insertItems(vo,session);
		
	}

	@Override
	public void deleteItems(ItemsVO vo,HttpServletRequest request) {
		String[] itemID = request.getParameterValues("itemID");
		for(int i = 0; i < itemID.length; i++) {
			vo.setItemID(itemID[i]);
			dao.deleteItems(vo);
		}
		
	}

	@Override
	public List<ItemsVO> getItemsAllSort(HttpSession session,HttpServletRequest request) {
		String sortItems = request.getParameter("sortItems");
		String sortType = request.getParameter("sortType");
		String sql = "select * from items where ownership='"+session.getAttribute("userId")+"' order by "+sortItems+ " " + sortType;
		return dao.getItemsAllSort(sql);
	}

	@Override
	public String itemRelease_proc(ItemsVO vo, HttpSession session, HttpServletRequest request,MessagesVO msVo) {
		List<UsersVO> list = usersService.getUsersAll();
		boolean check = false;
		String ownerShip = request.getParameter("ownerShip");
		String[] itemID = request.getParameterValues("itemID");
		//ID 여부 체크
		for(int i = 0; i<list.size(); i++) {
			if(ownerShip.equals(list.get(i).getId())) {
				check = true;
			}
		}

		if(check) {
			//해당 아이템 정보 테이블의 ownerShip을 input에서 적은 아이디로 변경
			vo.setOwnership(ownerShip);
			int count = 0;
			for(int i = 0; i < itemID.length; i++) {
				vo.setItemID(itemID[i]);
				dao.releaseItem(vo);
				count++;
			}
			msVo.setContents1(session.getAttribute("userId") + "님이 " + count + "개의 물품을 " +ownerShip +" 님에게 입고처리 했습니다.");
			msVo.setOwnerShip(ownerShip);
			messagesService.insertMessages(msVo);
			return "itemReleaseList.do";
		}else {
			return "itemReleaseList.do";//해당 아이디가 없다면 아무런 연산을 하지 않는다.
		}
		
		//추후 알림 테이블 생성 시 insert 한 ID에 해당되는 알림 테이블에 데이터 입력
		
	}

	@Override
	public List<ItemsVO> itemsSearchInfoTest(HttpServletRequest request) {
		String searchType = request.getParameter("searchType");
		String searchContent = request.getParameter("searchContent");
		String sql = "select * from items where " + searchType +" like '%"+searchContent+"%' order by itemID asc";
		return dao.itemsSearchInfo(sql);
	}

	@Override
	public void updateItems(ItemsVO vo, HttpServletRequest request) {
		vo.setItemName(request.getParameter("itemName"));
		vo.setItemSortation(request.getParameter("itemSortation"));
		vo.setItemType(Integer.parseInt(request.getParameter("itemType")));
		vo.setHandlingGrade(Integer.parseInt(request.getParameter("handlingGrade")));
		vo.setSecurityLevel(Integer.parseInt(request.getParameter("securityLevel")));
		dao.updateItems(vo);
	}



//	@Override
//	public void updateItems(ItemsVO vo) {
//		dao.updateItems(vo);
//		
//	}

}
