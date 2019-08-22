package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.Employee;

@Configuration
public class AppConfig {
	
	@Bean
	public Employee emp() {
		
		return new Employee(101, "Vlad");
	}
}
