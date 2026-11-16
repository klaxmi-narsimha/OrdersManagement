package com.kln.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kln.dto.ItemAddRequestDTO;
import com.kln.dto.ItemResponseDTO;
import com.kln.model.Item;
import com.kln.service.ItemService;



@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@PostMapping("/add")
	public ResponseEntity<ItemAddRequestDTO> addItem(@RequestBody ItemAddRequestDTO item){
	
		itemService.addItem(item);
		
		return new ResponseEntity(item,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Item> finditemById(@PathVariable int id){
		
		Item itemById = itemService.findItemById(id);
		
		return new ResponseEntity(itemById,HttpStatus.FOUND);
	}

}
