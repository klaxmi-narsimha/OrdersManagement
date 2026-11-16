package com.kln.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kln.dto.OrderRequestDTO;
import com.kln.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/add")
	public ResponseEntity<OrderRequestDTO> addOrder(@RequestBody OrderRequestDTO order){
		
		orderService.addOrder(order);
		
		return new ResponseEntity(order,HttpStatus.CREATED);
		
		
	}

}
