package com.kln.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customer_addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private int pincode;
	
	private String city;
	
	@Column(nullable = false)
	private String village;
	
	@Column(nullable = false)
	private String colonyName;
	
	private String houseNumber;
	
	@OneToMany(mappedBy = "address")
	private List<Customer> customer;

	public Address(int pincode, String city, String village, String colonyName, String houseNumber,
			List<Customer> customer) {
		super();
		this.pincode = pincode;
		this.city = city;
		this.village = village;
		this.colonyName = colonyName;
		this.houseNumber = houseNumber;
		this.customer = customer;
	}
	
	

}
