package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.model.RegisterForm;

@Controller
public class RegisterController {

	@Autowired
	private RegisterForm regForm;
}
