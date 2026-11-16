package com.kln.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddressRequestDTO {
	
    private int pincode;
	
	private String city;
	
	private String village;
	
	private String colonyName;
	
	private String houseNumber;
	

}
