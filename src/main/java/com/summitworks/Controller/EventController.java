package com.summitworks.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.summitworks.entity.*;
import com.summitworks.repo.*;

@Controller
public class EventController implements WebMvcConfigurer {
	@Autowired
	EventsRepo EventsRepo;

	@RequestMapping("/EventsManagement")
	public String welcomeHotel(Model model)
	{
		List<Events> listEvents=EventsRepo.findAll();
		model.addAttribute("events",listEvents);
		return "eventManagement";
	}

	@RequestMapping("/insert_event")
	public String requestRoom(Model model)
	{
		Events e = new Events();
		model.addAttribute(e);
		return "addEventForm";
	}
	@RequestMapping(value="/insert_event",method = RequestMethod.POST)
	public String saveReservation(@Valid @ModelAttribute("events") Events r,BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
			System.out.println("error");
			return "addEventForm";
		}
		String eventName=r.getEventName();
		String eventDescription=r.getEventDescription();
		String eventCategory=r.getEventCategory();
		Date startDate=r.getStartDate();
		Date endDate=r.getEndDate();
		int startTime=r.getStartTime();
		int endtTime=r.getEndTime();
		String location = r.getLocation();
		boolean eventRegistration=r.getEventRegistration();
		double adultTicketPrice=r.getAdultTicketPrice();
		double childTicketPrice=r.getChildTicketPrice();
		Events event = new Events();
		event.setEventName(eventName);
		event.setEventDescription(eventDescription);
		event.setEventCategory(eventCategory);
		event.setStartDate(startDate);
		event.setEndDate(endDate);
		event.setStartTime(startTime);
		event.setEndTime(endtTime);
		event.setLocation(location);
		event.setEventRegistration(eventRegistration);
		event.setAdultTicketPrice(adultTicketPrice);
		event.setChildTicketPrice(childTicketPrice);
		EventsRepo.save(event);

		return "redirect:/EventsManagement";
	}

}
