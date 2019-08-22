package com.training;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class OrderBook {
	
	private long orderId;
	private Customer cust;
	
	@Autowired
	private List<Product> products;
	
	public void init() {
		
		Logger log = Logger.getAnonymousLogger();
		log.info("Init has been summoned");
	}
	
	public void destroy() {
		
		Logger log = Logger.getAnonymousLogger();
		log.info("A wild destroyer has appeared");
	}
}
