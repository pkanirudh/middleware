package com.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.training.models.Address;
import com.training.models.Doctor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.training.controllers")
public class MvcConfig implements WebMvcConfigurer {
	
	@Bean
	public InternalResourceViewResolver resolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	@Bean
	public Doctor doctor() {
		
		return new Doctor();
	}
	
	@Bean
	public Address address() {
		return new Address();
		
	}
	@Bean
	public ModelAndView mdlView() {
		
		return new ModelAndView();
		
	}
}
