package com.kln.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.kln.enumeration.OrderStatus;
import com.kln.enumeration.PaymentMode;
import com.kln.enumeration.PaymentStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	private long totalPrice;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "order")
	private List<OrderItem> orderItems=new ArrayList<OrderItem>();
	
	@Enumerated(EnumType.STRING)
	private PaymentMode paymentMode;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	private LocalDateTime orderDate;
	
	@PrePersist
	public void orderDate() {
		
		this.orderDate=LocalDateTime.now();
		this.orderStatus=OrderStatus.InProcess;
		
		
	}

	public Order(Customer customer, long totalPrice, List<OrderItem> orderItems, PaymentMode paymentMode,
			PaymentStatus paymentStatus, OrderStatus orderStatus, LocalDateTime orderDate) {
		super();
		this.customer = customer;
		this.totalPrice = totalPrice;
		this.orderItems = orderItems;
		this.paymentMode = paymentMode;
		this.paymentStatus = paymentStatus;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
	}

	
	}



