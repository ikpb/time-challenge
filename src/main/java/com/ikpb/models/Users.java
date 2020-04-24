package com.ikpb.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Component
@Entity
@Table(name = "applicationusers")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "username")
public class Users {
	
	@Id
	@Valid
	@NotBlank
	@Column(name="user_name")
	@Size(min=3,max=12)
	@Pattern(regexp="^\\w+\\.?\\w+$")
	private String username;
	
	
	@Valid
	@NotBlank
	@Column(name = "passwords")
	@Size(min=6, max=20)
	private String password;
	
	@Transient
	@OneToMany(mappedBy = "username", fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Events.class)
	private List<Events> myEvents = new ArrayList<Events>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((myEvents == null) ? 0 : myEvents.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Users other = (Users) obj;
		if (myEvents == null) {
			if (other.myEvents != null)
				return false;
		} else if (!myEvents.equals(other.myEvents))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public Users(@Valid @NotBlank @Size(min = 3, max = 12) @Pattern(regexp = "^\\w+\\.?\\w+$") String username,
			@Valid @NotBlank @Size(min = 6, max = 20) String password, List<Events> myEvents) {
		super();
		this.username = username;
		this.password = password;
		this.myEvents = myEvents;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", myEvents=" + myEvents + "]";
	}


	

}
