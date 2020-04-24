package ikpb.com.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.ikpb.models.Events;
import com.ikpb.repository.EventRepository;


public class EventServiceImpl implements EventService {

	private EventRepository er;
	
	
	
	public EventServiceImpl(EventRepository er) {
		super();
		this.er = er;
	}

	@Override
	public List<Events> getEventss() {
		
		return er.findAll();
	}

	@Override
	public Optional<Events> getFormById(int id) {
		
		return er.getEventByEventId(id);
	}

	@Override
	public Events addEvents(@Valid Events events) {
		
		return er.save(events);
	}

	@Override
	public Events updateEvents(Events events) {
		
		if(er.existsById(events.getEventId())) {
			return er.save(events);
		}else {
			return null;
		}
	}

	@Override
	public String deleteFormById(int id) {
		
		if(er.existsById(id)) {
			er.deleteById(id);
			return "Deleted";
		}else {
			return null;
		}
	}

}
