package com.ikpb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ikpb.models.Events;

@Repository
public interface EventRepository extends JpaRepository<Events, Integer>{
	@Query("select u from Events u where u.event_id = ?1")
	public Optional<Events> getEventByEventId(int id);
}
