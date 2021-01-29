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
import com.summitworks.entity.*;
import com.summitworks.repo.*;
import com.summitworks.services.AmazonS3ClientService;

@Controller
public class EventController implements WebMvcConfigurer {
	@Autowired
	EventsRepo EventsRepo;
	@Autowired
    private AmazonS3ClientService amazonS3ClientService;

	@RequestMapping("/EventsManagement")
	public String eventManagement(Model model) {
		List<Events> listEvents = EventsRepo.findAll();
		model.addAttribute("events", listEvents);
		return "eventManagement";
	}
	@RequestMapping("/UserView")
	public String userView(Model model) {
		List<Events> listEvents = EventsRepo.findAll();
		model.addAttribute("events", listEvents);
		return  "userview";
	}

	@RequestMapping("/insert_event")
	public String insertEvent(Model model) {
		Events e = new Events();
		model.addAttribute(e);
		return "addEventForm";
	}

	@RequestMapping(value = "/insert_event", method = RequestMethod.POST)
	public String saveEvent(@Valid @ModelAttribute("events") Events r,@RequestParam("file") MultipartFile file, BindingResult bindingResult) {
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
	@RequestMapping(value = "/update_event", method = RequestMethod.POST)
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
		return "redirect:/EventsManagement";
	}
	@RequestMapping(value = "/insert_image", method = RequestMethod.POST)
	public String insertImageEvent(@RequestParam("file") MultipartFile file) {
		String name = file.getOriginalFilename();
		System.out.println(name);
		this.amazonS3ClientService.uploadFileToS3Bucket(file, true);
		return "redirect:/EventsManagement";
	}
	
	

}
