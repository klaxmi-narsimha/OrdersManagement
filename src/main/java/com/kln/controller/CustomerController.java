package com.kln.controller;

import com.kln.dao.CustomerRepository;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kln.dto.CustomerDetailsRequestDTO;
import com.kln.dto.CustomerLoginRequestDTO;
import com.kln.model.Customer;
import com.kln.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	
	
//	@PostMapping("/add")
//	public ResponseEntity<CustomerDetailsRequestDTO> addNewCustomer(@RequestBody CustomerDetailsRequestDTO customer){
//	
//		customerService.addNewCustomer(customer);
//		
//		return new ResponseEntity<>(customer,HttpStatus.CREATED);
//	}

	@PostMapping("/register")
	public ResponseEntity<String> customerLogin(@RequestBody CustomerDetailsRequestDTO customer){
		
		
        customerService.addNewCustomer(customer);
		
		return new ResponseEntity<>("created",HttpStatus.CREATED);
	}

		
	}
	

