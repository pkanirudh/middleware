package com.training.apps;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.DiscountNotification;
import com.training.DiscountService;
import com.training.configs.LookUpConfig;

public class LookUpApplication {
	
	public static void main(String[] args) {
		Logger log = Logger.getAnonymousLogger();
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(LookUpConfig.class);
		
		DiscountService service = ctx.getBean(DiscountService.class);
				
		DiscountNotification notifyBean = service.getDiscount("tv");
		
		log.info(Double.toString(notifyBean.showDiscount()));
		ctx.close();
	}

}

