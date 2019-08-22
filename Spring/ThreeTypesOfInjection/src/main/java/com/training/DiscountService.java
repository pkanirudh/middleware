package com.training;

import org.springframework.beans.factory.annotation.Lookup;

public abstract class DiscountService {
	
	@Lookup
	public abstract DiscountNotification getDiscount(String itemName);
	
	public String hello() {
		return "Hello";
	}
}
