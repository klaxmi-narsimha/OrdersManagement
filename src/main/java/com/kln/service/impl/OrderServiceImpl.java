package com.kln.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.kln.builder.OrderBuilder;
import com.kln.dao.OrderRepository;
import com.kln.dto.OrderRequestDTO;
import com.kln.model.Order;
import com.kln.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderBuilder orderBuilder;
	
	@Override
	public void addOrder(OrderRequestDTO orderDTO) {

		
		Order order = orderBuilder.buildOrderFromOrderRequestDTO(orderDTO);
		
		orderRepository.save(order);
		
		

		
		
	}

}
