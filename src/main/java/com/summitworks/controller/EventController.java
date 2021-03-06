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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.summitworks.entity.Events;
import com.summitworks.entity.EventsRegistration;
import com.summitworks.repo.EventsRegistrationRepo;
import com.summitworks.repo.EventsRepo;
import com.summitworks.services.AmazonS3ClientService;



@Controller
public class EventController implements WebMvcConfigurer {
	@Autowired
	EventsRepo EventsRepo;
	@Autowired
	EventsRegistrationRepo EventsRegistrationRepo;

	@Autowired
    private AmazonS3ClientService amazonS3ClientService;

	@RequestMapping("/admin/eventManagement")
	public String eventManagement(Model model) {
		List<Events> listEvents = EventsRepo.findAll();
		model.addAttribute("events", listEvents);
		return "eventManagement";
	}
	@RequestMapping("/admin/eventRegistration")
	public String eventRegistration(Model model) {
		List<EventsRegistration> listEventsRe = EventsRegistrationRepo.findAll();
		model.addAttribute("eventsReg", listEventsRe);
		return "eventRegistration";
	}
	@RequestMapping("/home")
	public String userView(Model model) {
		List<Events> listEvents = EventsRepo.findAll();
		model.addAttribute("events", listEvents);
		return  "userview";
	}

	@RequestMapping("/admin/insert_event")
	public String insertEvent(Model model) {
		Events e = new Events();
		model.addAttribute(e);
		return "addEventForm";
	}

	@RequestMapping(value = "/admin/insert_event", method = RequestMethod.POST)
	public String saveEvent(@Valid @ModelAttribute("events") Events r, BindingResult bindingResult ,@RequestParam("file") MultipartFile file) {
		System.out.println("Post");
		
		System.out.println(bindingResult.hasErrors());
		if (bindingResult.hasErrors()) {
			System.out.println("error");
			return "addEventForm";
		}
		String name="";
		if (file.isEmpty())
		{
			name="noimageupload.png";
		}
		else {
			name = file.getOriginalFilename();	
		}
		System.out.println(name);
		this.amazonS3ClientService.uploadFileToS3Bucket(file, true);
		String eventImage = "https://ngobucketproject.s3.us-east-2.amazonaws.com/"+name;
		r.setEventImage(eventImage);
		EventsRepo.save(r);
		return "redirect:/home";
	}
	@RequestMapping("/admin/edit_event/{id}")
	public ModelAndView showEditEvent(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_event");
		Optional<Events> e =EventsRepo.findById(id);
		mav.addObject("events",e);
		return mav;
	}
	@RequestMapping("/show_event/{id}")
	public String showEvent(@PathVariable(name = "id") int id,Model model) {
		Optional<Events> eventResponse =  EventsRepo.findById(id);
		Events e = eventResponse.get();
		String eventName = e.getEventName();
		System.out.println(eventName);
	
		model.addAttribute("events", e);
		
		return "showEvent";
	}
	@RequestMapping("/admin/delete_event/{id}")
	public String deleteEvent(@PathVariable(name = "id") int id) {
		EventsRepo.deleteById(id);
		return "redirect:/home";
	}
	@RequestMapping(value = "/admin/update_event", method = RequestMethod.POST)
	public String updateEvent(@Valid @ModelAttribute("events") Events r,@RequestParam("file") MultipartFile file, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("error");
			return "addEventForm";
		}
		String name = file.getOriginalFilename();
		System.out.println(name);
		this.amazonS3ClientService.uploadFileToS3Bucket(file, true);
		String eventImage = "https://ngobucketproject.s3.us-east-2.amazonaws.com/"+name;
		r.setEventImage(eventImage);
		EventsRepo.save(r);
		return "redirect:/home";
	}
	@RequestMapping(value = "/register_event/{id}", method = RequestMethod.POST)
	public String registerEvent(@Valid @ModelAttribute("events") Events r, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("error");
			return "addEventForm";
		}
		EventsRepo.save(r);
		return "redirect:/home";
	}
	@RequestMapping(value = "/insert_image", method = RequestMethod.POST)
	public String insertImageEvent(@RequestParam("file") MultipartFile file) {
		String name = file.getOriginalFilename();
		System.out.println(name);
		this.amazonS3ClientService.uploadFileToS3Bucket(file, true);
		return "redirect:/home";
	}

}
