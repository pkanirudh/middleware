package com.training.configs;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.training.DiscountNotification;
import com.training.DiscountService;


@Configuration
public class LookUpConfig {
	
	@Bean
	@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public DiscountNotification notification(String itemName) {
		return new DiscountNotification();
	}
	
	@Bean
	@Scope(scopeName=ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DiscountService service() {
		
		return new DiscountService() {
			@Override
			public DiscountNotification getDiscount(String itemName) {
				return new DiscountNotification(itemName);
			}
		};
	}
}
