package com.kln.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kln.model.Customer;

import jakarta.transaction.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Transactional
	public Customer findCustomerByEmail(String mail);
	

}
