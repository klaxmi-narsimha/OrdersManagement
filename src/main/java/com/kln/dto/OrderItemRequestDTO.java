package com.kln.dto;

import java.util.List;

import com.kln.enumeration.OrderStatus;
import com.kln.enumeration.PaymentMode;
import com.kln.enumeration.PaymentStatus;
import com.kln.model.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequestDTO {
	
	private int itemId;
	
	private String itemColor;
	
	private int itemPrice;
	
	private int itemQuantity;
	
	private long totalPrice;
}
