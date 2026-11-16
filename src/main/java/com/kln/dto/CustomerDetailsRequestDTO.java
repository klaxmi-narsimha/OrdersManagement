package com.kln.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetailsRequestDTO {
	
	private String name;
	
	private long mobileNumber;
	
	private String email;
	
	public CustomerAddressRequestDTO address;

}
