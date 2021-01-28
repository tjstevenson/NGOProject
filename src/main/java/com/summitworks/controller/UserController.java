package com.summitworks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.summitworks.entity.User;
import com.summitworks.repo.UserRepo;

@Controller
public class UserController implements WebMvcConfigurer {


	@Autowired
	UserRepo UserRepo;
	
	@RequestMapping("/UserManagement")
	public String userManagment(Model model)
	{
		List<User> listUsers=UserRepo.findAll();
		model.addAttribute("user",listUsers);
		return "UserManagement";
	}
	
}