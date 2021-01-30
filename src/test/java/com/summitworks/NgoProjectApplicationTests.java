package com.summitworks;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.summitworks.entity.Events;
import com.summitworks.entity.User;import com.summitworks.repo.EventsRepo;
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
		
//		User u1 = new User("Bob", "Smith", "bob@mail.com","bsmith","password", "ROLE_ADMIN", true);
//		User u2 = new User("mike", "jones", "mike@mail.com","mjones","password", "ROLE_USER", true);
//		User u3 = new User("Jane", "Brady", "Jane@mail.com","jbrady","password", "ROLE_ADMIN", true);
//		User u4 = new User("Alex", "Stevens", "alex@mail.com","aStevens","password", "ROLE_USER", true);
//		
//		Events event = new Events(1,"name", "description", "category", d1, d2,
//				3, 4,"location","image", true, 20.00, 20.00);	
//		user.getEvents().add(event);
//		event.getUsers().add(user);
		
//		this.userRepo.save(u1);
//		this.userRepo.save(u2);
//		this.userRepo.save(u3);
//		this.userRepo.save(u4);
//		
//		Optional<User> myUser= userRepo.findByUserName("aStevens");
//		User user1 = myUser.get();
//		System.out.println(user1.getPassword());
	}	

}
