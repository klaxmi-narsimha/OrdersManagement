package com.kln.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.kln.dto.ItemAddRequestDTO;
import com.kln.dto.ItemResponseDTO;
import com.kln.model.Item;


public interface ItemService {
	
	public String addItem(ItemAddRequestDTO item);

	public Item findItemById(int id);

	public List<ItemResponseDTO> items();
	

}
