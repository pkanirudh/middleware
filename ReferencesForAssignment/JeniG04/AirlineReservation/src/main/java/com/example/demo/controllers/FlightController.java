package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Flight;
import com.example.demo.models.FlightListModel;
import com.example.demo.service.FlightService;


@Controller
public class FlightController {
	
	@Autowired
	private Flight flight;

	@Autowired
	private FlightService service;
	
	@Autowired
	private ModelAndView mdlView;
	
	@GetMapping("/findFlights")
	public ModelAndView initForm() {
		
		mdlView.setViewName("findflight");
		mdlView.addObject("command", flight);
		return mdlView;
	}
	
//	@GetMapping("/findFlights")
//	public List<Flight> getAll(){
//		
//		List<Flight> flightList= new ArrayList<>();
//		
//		this.service.findAll().forEach(eachObject -> {
//			flightList.add(eachObject);
//		});
//		return flightList;
//		}
	
	@RequestMapping(path="/findMyFlight")
	public String onSubmit(@Valid @ModelAttribute("command") Flight flight, BindingResult result, Model model) {
		
//		List<Flight> flightList= new ArrayList<>();
//
//		
//		
//		 flightList = (List<Flight>) this.service.findAll(flight.getSource(),flight.getDestination());
//		 model.addAttribute("flightList", flightList);
//
//		return "success";
		Iterable<Flight> flightlist=this.service.findAll(flight.getSource(),flight.getDestination());
		model.addAttribute("flightlist", flightlist);
		return "success";
	}

}
