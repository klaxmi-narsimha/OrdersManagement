package com.kln.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserConfiguration {
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
		
	return 	httpSecurity.
			csrf(csrf ->csrf.disable()).
			authorizeHttpRequests(auth -> auth.requestMatchers("/order/**").authenticated().
				requestMatchers("/customer/register","/item/**").permitAll()).
		formLogin(Customizer.withDefaults()).
		httpBasic(Customizer.withDefaults()).build();
		
	}
	
	
	

}
