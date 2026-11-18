package com.kln.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kln.model.Customer;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	CustomerService customerService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Customer customer = customerService.findCustomerByEmail(username);
	
		return User.builder()
				.username(customer.getEmail())
				.password(customer.getPassword())
				.roles("USER")
				.build();
	}

}
