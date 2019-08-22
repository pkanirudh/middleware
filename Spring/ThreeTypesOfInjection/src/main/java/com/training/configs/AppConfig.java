package com.training.configs;
import com.training.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.Customer;

@Configuration
public class AppConfig {
	@Bean
	public Customer customer() {
		Customer customer = new Customer();
		customer.setCustomerName("Loki");
		customer.setCustomerId(100);
		customer.setEmail("Loki");
		customer.setPhoneNumber(98765435);
		return customer;
	}
	
	@Bean
	public Product laptop() {
		Product product = new Product(100, "Alienware 17", 1, 200000.00D);
		
		return product;
	}
	
	@Bean
	public Product mobile() {
		Product product = new Product(101, "One Plus 7", 1, 69000.00D);
		
		return product;
	}
	
	@Bean
	public Product longpig() {
		Product product = new Product(102, "Bob", 1, 4200.00D);
		
		return product;
	}
	
	@Bean()
	public OrderBook orderBook() {
		
		//OrderBook orderBook = new OrderBook(1000, customer(), product());
		
		OrderBook book = new OrderBook();
		book.setCust(customer());
		book.setOrderId(420);
		return book;
	}
	
	@Bean
	public Address billingAddress() {
		Address address = new Address("OTP", "Chennai", 600032);
		return address;
		
	}
	
	@Bean
	public Address shippingAddress() {
		Address address = new Address("RMZ", "Tharamani", 600034);
		return address;
	}
	
}
