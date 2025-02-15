package com.example.demo.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.demo.service.DateService;

@Controller
public class DateController {

	@Autowired
	private LocalDate dateOfBirth;
	
	@Autowired
	private DateService service;
	
	@Autowired
	private ModelAndView mdlView;

	
	
	@GetMapping("/dateApp")
	public ModelAndView initForm() {
		
		mdlView.setViewName("date2");
		mdlView.addObject("command", dateOfBirth);
		return mdlView;
	}
	
	@PostMapping("/findAge")
	public String onSubmit(@Valid @ModelAttribute("command") LocalDate dateOfBirth,Model model, BindingResult result){
		int age = this.service.age(dateOfBirth);
		
		model.addAttribute("age", age);
		
		return "date2";
	}
	
}
