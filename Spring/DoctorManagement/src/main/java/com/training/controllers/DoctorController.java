package com.training.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.training.models.Doctor;

@Controller
public class DoctorController {
	
	@Autowired
	public Doctor doctor;
	
	@Autowired
	private ModelAndView mdlView;
	
	@GetMapping("/addDoctor")
	public ModelAndView initForm() {
		
		mdlView.setViewName("addDoctor");
		
		mdlView.addObject("command", doctor);
		return mdlView;
	}
	
	@ModelAttribute("depts")
	public String[] departments() {
		return new String[] {"Blood Transfusion", "Neurologist", "OB/GYN"};
	}
	
	@PostMapping("/addDoctor")
	public String onSubmit(@Valid @ModelAttribute("command") Doctor doctor, BindingResult result) {
		
		String nextPage = "success";
		if(result.hasErrors())
			nextPage = "addDoctor";
		return nextPage;
	}		
}
