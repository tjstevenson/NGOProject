package com.summitworks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.summitworks.entity.*;
import com.summitworks.repo.*;

@Controller
public class EventController {
	@Autowired
	EventsRepo EventsRepo;

	@Autowired
	UserRepo UserRepo;
	
	@RequestMapping("/EventsManagement")
	public String welcomeHotel(Model model)
	{
		List<Events> listEvents=EventsRepo.findAll();
		model.addAttribute("events",listEvents);
		return "eventManagement";
	}

	@RequestMapping("/UserManagement")
	public String userManagment(Model model)
	{
		List<User> listUsers=UserRepo.findAll();
		model.addAttribute("user",listUsers);
		return "UserManagement";
	}

}
