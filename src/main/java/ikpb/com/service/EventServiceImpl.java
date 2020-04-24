package ikpb.com.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.ikpb.models.Events;
import com.ikpb.repository.EventRepository;

@Service
public class EventServiceImpl implements EventsService {

	private EventRepository er;
	@Autowired
	public EventServiceImpl(EventRepository er) {
		this.er = er;
	}

	@Override
	public List<Events> getEventss() {
		
		return er.findAll();
	}

	@Override
	public Optional<Events> getFormById(int id) {
		
		return er.findById(id);
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
