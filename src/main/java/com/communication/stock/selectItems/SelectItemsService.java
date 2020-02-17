package com.communication.stock.selectItems;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface SelectItemsService {
	List<SelectItemsVO> itemQuentity(HttpSession session);
}
