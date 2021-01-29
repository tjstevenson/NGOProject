package com.summitworks.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.summitworks.entity.User;
import com.summitworks.repo.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	UserRepo urepo;
	
	@Override
	public boolean authenticate(String email, String password) {
		List<User> list = urepo.findAll();
		for(User u : list) {
			if(u.getEmail().equals(email)&& u.getPassword().equals(password))
				return true;
		}
		return false;		
	}

}
