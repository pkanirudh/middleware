package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Customer {
	private long customerId;
	private String customerName;
	private String email;
	private long phoneNumber;
	
	//Field Injection - tries by type and name
	
	@Autowired
	@Qualifier("billingAddress")
	private Address address;
}
