package com.communication.stock.itemType.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.communication.stock.itemType.ItemTypeService;
import com.communication.stock.itemType.ItemTypeVO;

@Service
public class ItemTypeServiceImpl implements ItemTypeService{

	@Autowired
	ItemTypeDAO dao;
	
	@Override
	public List<ItemTypeVO> itemTypeAll() {
		return dao.itemTypeAll();
	}
	
}
