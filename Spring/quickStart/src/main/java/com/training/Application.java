package com.training;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
//		Doctor ram = (Doctor)ctx.getBean("doctor");
//		
//		System.out.println(ram);
//		System.out.println(ram.getAddress());
//		
//		Doctor saran = (Doctor) ctx.getBean("surgeon");
//		
//		System.out.println(saran);
//		System.out.println(saran.hashCode());
//		
//		Doctor saranteja = (Doctor) ctx.getBean("surgeon");
//		
//		System.out.println(saranteja);
//		System.out.println(saranteja.hashCode());
		ctx.close();
	}
}
