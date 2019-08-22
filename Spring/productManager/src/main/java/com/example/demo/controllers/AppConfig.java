package com.example.demo.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Product;

@Configuration
public class AppConfig {
	
	@Bean
	public Product laptop() {
		return new Product(101, "Predator", "images/predator.jpg", 75000.00D, 4.2);
	}
	
	@Bean
	public Product printer() {
		return new Product(102, "HP Printer", "images/printer.jpg", 10000.00D, 4.0);
	}
	
	@Bean
	public Product mobilePhone() {
		return new Product(103, "K20 Pro", "images/mobile.jpg", 21000.00, 4.7);
	}
}
