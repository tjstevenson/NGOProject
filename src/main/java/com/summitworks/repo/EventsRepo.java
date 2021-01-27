package com.summitworks.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summitworks.entity.Events;


public interface EventsRepo extends JpaRepository<Events, Integer> {

}
