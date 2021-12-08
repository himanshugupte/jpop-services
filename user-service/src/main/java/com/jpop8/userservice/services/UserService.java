package com.jpop8.userservice.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jpop8.userservice.exceptions.ResourceNotFoundException;
import com.jpop8.userservice.models.User;

@Service
public class UserService {

	List<User> users = new ArrayList<>(Arrays.asList(new User(1L, "Himanshu Gupte", "himanshu@email.com"),
			new User(2L, "John Doe", "john@email.com")));

	public List<User> getAllUsers(String name) {
		if (name == null) {
			return users;
		} else {
			return users.stream().filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
					.collect(Collectors.toList());
		}
	}

	public User getUserById(Long id) {
		return users.stream().filter(user -> user.getId().equals(id)).findFirst()
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	}

	public User createUser(User user) {
		if (user != null && user.getId() == null) {
			user.setId(users.get(users.size() - 1).getId() + 1);
			user.setDateCreated(new Date());
			users.add(user);
		}
		return user;
	}

	public User updateUser(User user) {
		User temp = getUserById(user.getId());
		temp.setActive(user.isActive());
		temp.setEmail(user.getEmail());
		temp.setName(user.getName());
		temp.setLastUpdated(new Date());
		return temp;
	}

}
