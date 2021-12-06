package com.jpop8.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpop8.userservice.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public List<User> findByFirstNameContaining(String name);
}
