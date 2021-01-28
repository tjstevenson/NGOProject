package com.summitworks;

import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.summitworks.entity.Events;
import com.summitworks.entity.User;
import com.summitworks.repo.EventsRepo;
import com.summitworks.repo.UserRepo;

@SpringBootTest
class NgoProjectApplicationTests {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private EventsRepo eventsRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testingRepos() {

		Date d1 = new Date();
		Date d2 = new Date();
		Date d3 = new Date();
		Date d4 = new Date();
		
		User user = new User("Bob", "Smith", "bob@mail.com","password", "admin");
		
		Events event = new Events(1,"name", "description", "category", d1, d2,
				d3, d4,"location","true", "image", 20.00, 20.00);
	
		user.getEvents().add(event);
		event.getUsers().add(user);
		
		this.userRepo.save(user);
		this.eventsRepo.save(event);
	}	

}
