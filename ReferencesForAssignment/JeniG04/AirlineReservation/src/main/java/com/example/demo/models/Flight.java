package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="flight")
public class Flight {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String source;
	private String destination;
	private String airline;
	private String flight_number;
	private String price;
	private String travel_time;
	private int available_seat;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getFlight_number() {
		return flight_number;
	}
	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTravel_time() {
		return travel_time;
	}
	public void setTravel_time(String travel_time) {
		this.travel_time = travel_time;
	}
	public int getAvailable_seat() {
		return available_seat;
	}
	public void setAvailable_seat(int available_seat) {
		this.available_seat = available_seat;
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", source=" + source + ", destination=" + destination + ", airline=" + airline
				+ ", flight_number=" + flight_number + ", price=" + price + ", travel_time=" + travel_time
				+ ", available_seat=" + available_seat + "]";
	}
	
}
