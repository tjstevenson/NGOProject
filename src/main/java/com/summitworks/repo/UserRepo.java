package com.summitworks.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.summitworks.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByUserName(String userName);
	Optional<User> findByUserEmail(String email);
}