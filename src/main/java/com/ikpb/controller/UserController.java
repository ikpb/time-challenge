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

import com.ikpb.models.Users;

import ikpb.com.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
	
	
	private UserService us;
	
	public UserController(UserService us) {
		this.us = us;
	}

	@GetMapping
	public List<Users> getAllUsers(){
		return us.getUsers();
	}

	@GetMapping("/{username}")
	public Optional<Users> getUserByUsername(@PathVariable("username") String username) {
		return us.getUserByUsername(username);
	}

	@PostMapping
	public String addUser(@Valid @RequestBody Users user) {
		Users nUser = us.addUser(user);
		if(nUser !=null) {
			return "User Added Successfully";
		}else {
			return "User was not able to be saved";
		}
	}
	@PutMapping
	public String updateUser(@Valid @RequestBody Users user) {
		Users nUser = us.updateUser(user);
		if(nUser !=null) {
			return "User Updated Successfully";
		}else {
			return "User was not able to be updated";
		}
	}
	@DeleteMapping("/{username}")
	public String deleteUserById(@PathVariable("username")String username) {
		String deleted = us.deleteUserByUsername(username);
		if(deleted!=null) {
			return deleted;
		}else {
			return "No User by that Username";
		}
	}
		
}
