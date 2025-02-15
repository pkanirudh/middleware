package com.example.demo.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.example.demo.model.Address;
import com.example.demo.model.Car;
import com.example.demo.model.Dealer;
import com.example.demo.model.Owner;
import com.mongodb.MongoClient;



@Configuration
public class AppConfig {

	@Bean
	public MongoClient client() {
		
		return new MongoClient("localhost");
	}
	
	@Bean
	public MongoTemplate template() {
		return new MongoTemplate(client(), "test");
	}
	
	@Bean
	public Owner owner() {
		return new Owner(1, "Rico", address());
	}
	
	@Bean
	public Address address() {
		return new Address("Bucharest", 100152);
	}
	
	@Bean
	public Dealer dealer() {
		Dealer dealer = new Dealer();
		dealer.setDealerName("Diana Burnwood");
		
		return dealer;
	}
	
	@Bean
	public Car car() {
		
		Car car = new Car();
		car.setBrand("Dengue");
		car.setModel(Arrays.asList("Mos", "Muja", "Sun"));
		car.setOwner(owner());
		car.setDealer(dealer());
		
		return car;
		
		
	}
}
