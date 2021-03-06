package com.summitworks.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.summitworks.entity.Events;
import com.summitworks.entity.EventsRegistration;
import com.summitworks.entity.Role;
import com.summitworks.entity.User;
import com.summitworks.repo.EventsRegistrationRepo;
import com.summitworks.repo.EventsRepo;
import com.summitworks.repo.UserRepository;

@Controller
public class UserController implements WebMvcConfigurer {

	@Autowired
	UserRepository UserRepo;
	@Autowired
	EventsRepo EventsRepo;
	@Autowired
	EventsRegistrationRepo EventsRegistrationRepo;
		
	@Autowired
	PasswordEncoder PasswordEncoder;
	@Autowired
	com.summitworks.repo.RoleRepo RoleRepo;

	@RequestMapping("/admin/UserManagement")
	public String userManagment(Model model) {
		List<User> listUsers = UserRepo.findAll();
		model.addAttribute("users", listUsers);
		for (User u : listUsers) {
			System.out.println(u);
		}
		return "userManagement";
	}

	@RequestMapping("/admin/insert_user")
	public String addUser(Model model) {
		User u = new User();
		model.addAttribute(u);
		return "addUserForm";
	}
	
	@RequestMapping(value = "/admin/insert_user", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("user") User u, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println("error");
			return "addUserForm";
		}
		String role = u.getRole();
		String password = u.getPassword();
		u.setPassword(PasswordEncoder.encode(password));
	
		System.out.println(role);
		List<Role> r=new ArrayList<Role>();
		if (role.equals("admin"))
		{
			Role rol =new Role();
			rol.setId(1);
			rol.setName("ROLE_ADMIN");
			r.add(rol);
			u.setRoles(r);
		}
		else {
			Role rol =new Role();
			rol.setId(2);
			rol.setName("ROLE_USER");
			r.add(rol);
			u.setRoles(r);
		}
		
		UserRepo.save(u);
		return "redirect:/admin/UserManagement";
	}
	@RequestMapping("/admin/edit_user/{id}")
	public ModelAndView showEditEvent(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_user");
		Optional<User> e =UserRepo.findById(id);
		mav.addObject("user",e);
		return mav;
	}
	@RequestMapping("/admin/delete_user/{id}")
	public String deleteEvent(@PathVariable(name = "id") int id) {
		UserRepo.deleteById(id);
		return "redirect:/admin/UserManagement";
	}
	@RequestMapping("/register_event/{id}")
	public String addEvent(Model model, @PathVariable(name = "id") int id,RedirectAttributes redirAttrs) {
		Optional<Events> e=EventsRepo.findById(id);
		model.addAttribute(e);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
		Optional<User> u=UserRepo.findByEmail(auth.getName());
		int eventid = id;
		User userr = u.get();
		int userid =userr.getId();
		String email = userr.getEmail();
		String name =userr.getFirstname();
		EventsRegistration er=new EventsRegistration();
		er.setEventID(eventid);
		er.setUserEmail(email);
		er.setUserFirstName(name);
		er.setUserID(userid);
		EventsRegistrationRepo.save(er);
		redirAttrs.addFlashAttribute("message", "Successfull Registration");

		return "redirect:/home";
	}
	
}