package com.ikpb.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Component
@Entity
@Table(name = "events")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "eventId")
public class Events {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_id")
	private int eventId;
	

	@Column(name = "event_title")
	private String eventTitle;
	

	@Column(name = "location")
	private String location;

	@Column(name = "dateofevent")
	private String dateOfEvent;

	@Column(name = "timeofevent")
	private Date timeOfEvent;
	
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "archived")
	private boolean archived;
	
	@ManyToOne
	@JoinColumn(name="username")
	@JsonIdentityReference(alwaysAsId = true)
	private String username;

	public Events(int eventId, String eventTitle, String location, String dateOfEvent, Date timeOfEvent, boolean active,
			boolean archived, String username) {
		super();
		this.eventId = eventId;
		this.eventTitle = eventTitle;
		this.location = location;
		this.dateOfEvent = dateOfEvent;
		this.timeOfEvent = timeOfEvent;
		this.active = active;
		this.archived = archived;
		this.username = username;
	}

	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDateOfEvent() {
		return dateOfEvent;
	}

	public void setDateOfEvent(String dateOfEvent) {
		this.dateOfEvent = dateOfEvent;
	}

	public Date getTimeOfEvent() {
		return timeOfEvent;
	}

	public void setTimeOfEvent(Date timeOfEvent) {
		this.timeOfEvent = timeOfEvent;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + (archived ? 1231 : 1237);
		result = prime * result + ((dateOfEvent == null) ? 0 : dateOfEvent.hashCode());
		result = prime * result + eventId;
		result = prime * result + ((eventTitle == null) ? 0 : eventTitle.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((timeOfEvent == null) ? 0 : timeOfEvent.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Events other = (Events) obj;
		if (active != other.active)
			return false;
		if (archived != other.archived)
			return false;
		if (dateOfEvent == null) {
			if (other.dateOfEvent != null)
				return false;
		} else if (!dateOfEvent.equals(other.dateOfEvent))
			return false;
		if (eventId != other.eventId)
			return false;
		if (eventTitle == null) {
			if (other.eventTitle != null)
				return false;
		} else if (!eventTitle.equals(other.eventTitle))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (timeOfEvent == null) {
			if (other.timeOfEvent != null)
				return false;
		} else if (!timeOfEvent.equals(other.timeOfEvent))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Events [eventId=" + eventId + ", eventTitle=" + eventTitle + ", location=" + location + ", dateOfEvent="
				+ dateOfEvent + ", timeOfEvent=" + timeOfEvent + ", active=" + active + ", archived=" + archived
				+ ", username=" + username + "]";
	}
	
	
	
	
}
