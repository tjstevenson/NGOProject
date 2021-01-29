package com.summitworks.controller;

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

import com.summitworks.entity.Events;
import com.summitworks.entity.User;
import com.summitworks.repo.UserRepo;

@Controller
public class UserController implements WebMvcConfigurer {

	@Autowired
	UserRepo UserRepo;

	@RequestMapping("/UserManagement")
	public String userManagment(Model model) {
		List<User> listUsers = UserRepo.findAll();
		model.addAttribute("users", listUsers);
		for (User u : listUsers) {
			System.out.println(u);
		}
		return "userManagement";
	}

	@RequestMapping("/insert_user")
	public String addUser(Model model) {
		User u = new User();
		model.addAttribute(u);
		return "addUserForm";
	}
	
	@RequestMapping(value = "/insert_user", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("user") User u, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("error");
			return "addUserForm";
		}
		UserRepo.save(u);
		return "redirect:/EventsManagement";
	}
	
}