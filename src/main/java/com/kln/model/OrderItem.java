package com.kln.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "order_items")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id")
	private Item item;
	
	private String itemColor;
	
	private int itemPrice;
	
	private int itemQuantity;
	
	private long totalPrice;

	public OrderItem(Order order, Item item, String itemColor, int itemPrice, int itemQuantity, long totalPrice) {
		super();
		this.order = order;
		this.item = item;
		this.itemColor = itemColor;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.totalPrice = totalPrice;
	}

	
	
	
}
