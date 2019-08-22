package com.training;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration //Configuration Metadata
public class AppConfig {
	
	@Bean //To register java bean as spring bean
	@Lazy //Bean is only initialized when used
	public Doctor doctor() {
		Doctor ramesh= new Doctor();
		ramesh.setDoctorId(100);
		ramesh.setDoctorName("Ramesh");
		ramesh.setPhoneNumber(94929732);
		ramesh.setAddress(address());
		
		return ramesh;
	}
	
	@Bean
	public Doctor surgeon() {
			Doctor suresh= new Doctor();
			suresh.setDoctorId(101);
			suresh.setDoctorName("Suresh");
			suresh.setPhoneNumber(94929732);
		
		return suresh;
	}
	
	@Bean
	public Address address() {
		
		return new Address("Gandhi Street", "Chennai", 600100);
	}
}//@Annotation use to inject Item to store