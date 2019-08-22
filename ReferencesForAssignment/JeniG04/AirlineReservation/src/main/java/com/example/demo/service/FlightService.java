package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Flight;
import com.example.demo.repos.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepository repo;

	public Iterable<Flight> findAll(String source, String destination) {
		
	
		return repo.findAll(source,destination);
	}
}
