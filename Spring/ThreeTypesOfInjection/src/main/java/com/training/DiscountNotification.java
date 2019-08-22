package com.training;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class DiscountNotification {
	private String itemName;
	
	public double showDiscount() {
		double discountPercentage = 0.05;
		if(itemName.equalsIgnoreCase("tv")) {
			discountPercentage = 0.1;
		}
		
		return discountPercentage;
	}
}
