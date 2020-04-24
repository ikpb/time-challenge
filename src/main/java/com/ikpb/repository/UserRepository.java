package com.ikpb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ikpb.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
	@Query("select u from Users u where u.username = ?1")
	public Optional<Users> getUserByUsername(String username);
	
	@Query("select u from Users u where u.username = ?1")
	public List<Users> getAppUsersByUsername();
}

