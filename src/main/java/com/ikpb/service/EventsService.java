package com.ikpb.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.ikpb.models.Events;

public interface EventsService {

	public List<Events> getEventss();
	public Optional<Events> getFormById(int id);
	public Events addEvents(@Valid Events Events);
	public Events updateEvents(Events Events);
	public String deleteFormById(int id);
}
