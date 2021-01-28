package com.summitworks;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.summitworks.entity.Events;
import com.summitworks.repo.EventsRepo;
//hello #4
@SpringBootApplication
public class NgoProjectApplication extends SpringBootServletInitializer implements CommandLineRunner  {
	@Autowired
	EventsRepo EventsRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(NgoProjectApplication.class, args);
	}
	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	      return builder.sources(NgoProjectApplication.class);
	  }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Events event = new Events();
		event.setEventName("Test");
		event.setEventID(1);
		event.setEventRegistration("true");
		EventsRepo.save(event);
		
		
		
		
	}

}
