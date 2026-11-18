package com.kln.service;

import com.kln.dto.CustomerDetailsRequestDTO;
import com.kln.model.Customer;

public interface CustomerService {
	
	public void addNewCustomer(CustomerDetailsRequestDTO customer);
	
	public Customer findCustomerByEmail(String mail);

}
