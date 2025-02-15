package com.example.demo.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

@Service
public class DateService {

	public int age(LocalDate dateOfBirth) {
		
		Period difference = Period.between(dateOfBirth, LocalDate.now());
		return difference.getYears();
	}
}
