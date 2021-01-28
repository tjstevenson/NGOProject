package com.summitworks.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.summitworks.entity.*;
import com.summitworks.repo.*;

@Controller
public class EventController implements WebMvcConfigurer {
	@Autowired
	EventsRepo EventsRepo;

	@RequestMapping("/EventsManagement")
	public String welcomeHotel(Model model) {
		List<Events> listEvents = EventsRepo.findAll();
		model.addAttribute("events", listEvents);
		return "eventManagement";
	}

	@RequestMapping("/insert_event")
	public String insertEvent(Model model) {
		Events e = new Events();
		model.addAttribute(e);
		return "addEventForm";
	}

	@RequestMapping(value = "/insert_event", method = RequestMethod.POST)
	public String saveEvent(@Valid @ModelAttribute("events") Events r, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("error");
			return "addEventForm";
		}
		EventsRepo.save(r);
		return "redirect:/EventsManagement";
	}
	@RequestMapping("/edit_event/{id}")
	public ModelAndView showEditEvent(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_event");
		Optional<Events> e =EventsRepo.findById(id);
		mav.addObject("events",e);
		return mav;
	}
	@RequestMapping("/delete_event/{id}")
	public String deleteEvent(@PathVariable(name = "id") int id) {
		EventsRepo.deleteById(id);
		return "redirect:/EventsManagement";
	}
	
	

}
