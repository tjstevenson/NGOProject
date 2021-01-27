package com.summitworks.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventController {
	
	@RequestMapping("/")
	public String welcomeHotel(Model model)
	{

		return "eventManagement";
	}
}
