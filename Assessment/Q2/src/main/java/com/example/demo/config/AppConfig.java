package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.RegisterForm;

@Configuration
public class AppConfig {

	@Bean
	public RegisterForm regForm() {
		
		return new RegisterForm();
	}
}
