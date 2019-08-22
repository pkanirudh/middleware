package com.training.models;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Doctor {
	
	@NumberFormat(style = Style.NUMBER)
	@Range(max=1000,min=100,message="Doctor Id should be a number between 100 and 1000")
	private long doctorId;
	
	
	private String doctorName;
	
	private String specialisation;
	
	private long phoneNumber;
	
	private Address address;
}
