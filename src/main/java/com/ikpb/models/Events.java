package com.ikpb.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "events")
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
}
