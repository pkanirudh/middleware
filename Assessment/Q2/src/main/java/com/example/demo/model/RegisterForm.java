package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterForm {

	private String username;
	private String password;
	private String email;
	private String contact;
	private String city;
	private String zipCode;
}
