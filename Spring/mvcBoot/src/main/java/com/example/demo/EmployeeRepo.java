package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRepo {
	
	@GetMapping("/emp")
	public Employee getEmployee() {
		
		return new Employee(101, "Ramesh");
		
	}
}
