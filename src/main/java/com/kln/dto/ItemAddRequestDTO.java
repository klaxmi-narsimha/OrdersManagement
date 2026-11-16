package com.kln.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemAddRequestDTO {
	
	private String itemName;
	
	private String itemCategory;
	
	private String itemBrand;
	
	private int itemPrice;
	
	private int itemDiscount;

	private int itemQuantity;	

}
