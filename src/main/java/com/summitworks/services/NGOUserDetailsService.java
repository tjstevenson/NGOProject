package com.summitworks.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.summitworks.entity.NGOUserDetails;
import com.summitworks.entity.User;
import com.summitworks.repo.UserRepo;


@Service
public class NGOUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepo userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<User> user = userRepository.findByUserName(userName);
		System.out.println("***finding user***" + userName);
		
		user.orElseThrow(()-> new UsernameNotFoundException("Not Found: " + userName));
		
		return user.map(NGOUserDetails::new).get();
	} 

}
