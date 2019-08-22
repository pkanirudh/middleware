package com.training.apps;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.OrderBook;
import com.training.configs.AppConfig;

public class Application {
	
	public static void main(String[] args) {
		Logger log = Logger.getAnonymousLogger();
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		OrderBook book = ctx.getBean(OrderBook.class);
		
		book.getProducts().forEach(System.out::println);
		log.info(book.toString());
		
		ctx.close();
	}

}
