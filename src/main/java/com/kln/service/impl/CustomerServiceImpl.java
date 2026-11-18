package com.kln.service.impl;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kln.dao.CustomerRepository;
import com.kln.dto.CustomerDetailsRequestDTO;
import com.kln.model.Address;
import com.kln.model.Customer;
import com.kln.service.CustomerService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	//@Autowired
	//JavaMailSender mailSender;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public void addNewCustomer(CustomerDetailsRequestDTO customer) {
		
		//SimpleMailMessage mail = new SimpleMailMessage();
		Customer newCustomer = new Customer();
		
		 newCustomer.setName(customer.getName());
		 newCustomer.setPassword(encoder.encode(customer.getPassword()));
		 newCustomer.setMobileNumber(customer.getMobileNumber());
	     newCustomer.setEmail(customer.getEmail());
		 
	     Address address = new Address();

		address.setPincode(customer.address.getPincode());
		address.setCity(customer.address.getCity());
		address.setVillage(customer.address.getVillage());
		address.setColonyName(customer.address.getColonyName());
		address.setHouseNumber(customer.address.getHouseNumber());

		newCustomer.setAddress(address);

		customerRepository.save(newCustomer);
	}
	
	public Customer findCustomerByEmail(String mail) {
		
		return customerRepository.findCustomerByEmail(mail);	
		
		
	}
}
