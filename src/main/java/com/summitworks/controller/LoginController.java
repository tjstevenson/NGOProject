package com.summitworks.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class LoginController {
 
	@RestController
	public class HomeResource {

		@GetMapping("/")
		public String home() {
			System.out.println("Home");
			return("<h1>Welcome</h1>");
		}
		
		@GetMapping("/user")
		public String user() {
			System.out.println("User");
			return("<h1>Welcome User</h1>");
		}
		
		@GetMapping("/admin")
		public String admin() {
			System.out.println("Admin");
			return("<h1>Welcome Admin</h1>");
		}
	}   
}