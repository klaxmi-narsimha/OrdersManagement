package com.kln.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerLoginRequestDTO {

	private String username;
	
	private String password;
	
}
