package com.kln.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kln.dao.CustomerRepository;
import com.kln.dao.ItemRepository;
import com.kln.dao.OrderRepository;
import com.kln.dto.OrderItemRequestDTO;
import com.kln.dto.OrderRequestDTO;
import com.kln.model.Customer;
import com.kln.model.Item;
import com.kln.model.Order;
import com.kln.model.OrderItem;

@Component
public class OrderBuilder{
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	OrderRepository orderRepository;
	
	public Order buildOrderFromOrderRequestDTO(OrderRequestDTO orderDTO) {
		
		
		Optional<Customer> byId = customerRepository.findById(orderDTO.getCustomerId());
		Customer customer = byId.get();
		
	    List<OrderItem> orderItemList=new ArrayList();
	    
		Order order=Order.builder()
		.customer(customer)
		.totalPrice(orderDTO.getTotalPrice())
		.paymentMode(orderDTO.getPaymentMode())
		.paymentStatus(orderDTO.getPaymentStatus())
		.build();
		
		for(OrderItemRequestDTO orderItemDto:orderDTO.getOrderItems()) {
			    OrderItem orderItem = new OrderItem();
				int itemId = orderItemDto.getItemId();
				Item item = itemRepository.findById(itemId).get();
				orderItem.setItem(item);
				orderItem.setItemColor(orderItemDto.getItemColor());
				orderItem.setItemPrice(orderItemDto.getItemPrice());
				orderItem.setItemQuantity(orderItemDto.getItemQuantity());	
				orderItemList.add(orderItem);	
				orderItem.setOrder(order);
		}
		
		order.setOrderItems(orderItemList);
		
		return order;
		
		
	}

}
