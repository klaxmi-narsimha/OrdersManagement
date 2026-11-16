package com.kln.service;

import org.springframework.stereotype.Service;

import com.kln.dto.ItemAddRequestDTO;
import com.kln.model.Item;


public interface ItemService {
	
	public String addItem(ItemAddRequestDTO item);

	public Item findItemById(int id);
	

}
