package com.kln.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Items")
public class Item {
	
	public Item(String itemName, String itemCategory,String itemBrand, int itemPrice, int itemQuantity, int rating) {
		super();
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemBrand = itemBrand;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.rating = rating;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	private String itemName;
	
	@Column(nullable = false)
	private String itemCategory;
	
	@Column(nullable = false)
	private String itemBrand;
	
	
	@Column(nullable = false)
	private int itemPrice;
	
	private int itemDiscount=0;

	@Column(nullable = false)
	private int itemQuantity;
	
	private int rating;
	
	
	

}
