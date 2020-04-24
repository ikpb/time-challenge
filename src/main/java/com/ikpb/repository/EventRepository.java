package com.ikpb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikpb.models.Events;

@Repository
public interface EventRepository extends JpaRepository<Events, Integer>{

}
