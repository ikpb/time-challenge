package com.ikpb.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikpb.models.Events;


import ikpb.com.service.EventsService;

@RestController
@RequestMapping("/events")
@CrossOrigin
public class EventController {
	
	@Autowired
	private EventsService es;

	@GetMapping
	public List<Events> getAllEvents() {
		return es.getEventss();
	}

	@GetMapping("/{id}")
	public Optional<Events> getEventById(@PathVariable("id") int id) {
		return es.getFormById(id);
	}

	@PostMapping
	public String addEvent(@Valid @RequestBody Events Events) {
		Events nUser = es.addEvents(Events);
		if (nUser != null) {
			return "Events Submitted Successfully";
		} else {
			return "Events was not able to be saved";
		}
	}

	@PutMapping
	public String updateEvent(@Valid @RequestBody Events Events) {
		Events nEvents = es.updateEvents(Events);
		if (nEvents != null) {
			return "Events Updated Successfully";
		} else {
			return "Events was not able to be updated";
		}
	}

	@DeleteMapping("/{id}")
	public String deleteEventById(@PathVariable("id") int id) {
			String deleted = es.deleteFormById(id);
		if (deleted!= null) {
			return deleted;
		} else {
			return "No Events by that Id";
		}
	}

}
