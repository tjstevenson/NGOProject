package com.summitworks.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summitworks.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
    Optional<User> findByEmail(String email);
}
