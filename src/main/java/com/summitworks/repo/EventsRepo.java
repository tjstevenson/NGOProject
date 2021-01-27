package com.summitworks.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.summitworks.entity.Events;
@Repository
public interface EventsRepo extends JpaRepository<Events, Integer> {

}
