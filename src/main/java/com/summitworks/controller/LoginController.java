package com.summitworks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.summitworks.entity.User;
import com.summitworks.repo.UserRepo;
import com.summitworks.services.UserService;

@Controller
public class LoginController {
 
	@Autowired
	UserService uservice;
	
	@Autowired
	UserRepo urepo;
	
    @RequestMapping("/login")
    public String viewLoginPage() {
    	
        return "login";
    }
    
    @RequestMapping("/doLogin")
    public String doLogin() {
    	List<User> list = urepo.findAll();
    	//User u = uservice.authenticate(email, password) 
    	
    	return "redirect:/EventsManagement";
    }
    
    
}