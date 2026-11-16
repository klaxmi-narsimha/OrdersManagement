package com.kln.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kln.dao.ItemRepository;
import com.kln.dto.ItemAddRequestDTO;
import com.kln.exception.ItemNotFoundException;
import com.kln.model.Item;
import com.kln.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	@Override
	public String addItem(ItemAddRequestDTO item) {
		
		Item item2 = new Item();
		BeanUtils.copyProperties(item, item2);
		itemRepository.save(item2);
		return null;
	}

	@Override
	public Item findItemById(int id) {
		
	return itemRepository.findById(id).orElseThrow(()->new ItemNotFoundException("Item not found with with Id :"+id));
		


		
		
	}

}
