package com.example.demo.models;

import java.util.List;

public class FlightListModel {
	
	private List<Flight> flightList;

	public FlightListModel() {
	
	}
		
	
	public FlightListModel(List<Flight> flightList) {
		this.flightList = flightList;
	}

	public List<Flight> getFlightList() {
		return flightList;
	}

	public void setFlightList(List<Flight> flightList) {
		this.flightList = flightList;
	}
	
	
}
