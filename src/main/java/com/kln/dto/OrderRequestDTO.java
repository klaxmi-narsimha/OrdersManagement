package com.kln.dto;


import java.util.List;

import com.kln.enumeration.OrderStatus;
import com.kln.enumeration.PaymentMode;
import com.kln.enumeration.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
	
    private Integer customerId;
	
	private List<OrderItemRequestDTO> orderItems;
	
	private long totalPrice;
	
	private PaymentMode paymentMode;
	
	private PaymentStatus paymentStatus;

}
