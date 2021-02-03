package com.summitworks.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.summitworks.entity.Events;
import com.summitworks.entity.EventsRegistration;
@Repository
public interface EventsRegistrationRepo  extends JpaRepository<EventsRegistration, Integer> {

}
