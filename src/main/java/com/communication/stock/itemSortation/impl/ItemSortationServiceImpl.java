package com.communication.stock.itemSortation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.stock.itemSortation.ItemSortationService;
import com.communication.stock.itemSortation.ItemSortationVO;

@Service
public class ItemSortationServiceImpl implements ItemSortationService{

	@Autowired
	ItemSortationDAO dao;
	
	@Override
	public List<ItemSortationVO> itemSortation() {
		return dao.itemSortation();
	}

}
