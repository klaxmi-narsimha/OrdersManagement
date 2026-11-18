package com.kln.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponseDTO {
private String itemName;
	
    private int id;
    
	private String itemCategory;
	
	private String itemBrand;
	
	private int itemprice;
	
	private int itemDiscount;

	private int itemQuantity;
	
	private int rating;

}
