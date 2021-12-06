package com.jpop8.userservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jpop8.userservice.exceptions.ResourceNotFoundException;
import com.jpop8.userservice.models.User;
import com.jpop8.userservice.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers(String name) {
		if (name == null) {
			return this.userRepository.findAll();
		} else {
			return this.userRepository.findByFirstNameContaining(name);
		}
	}

	public User getUserById(Long id) {
		return this.userRepository.getById(id);
	}

	public User createUser(User user) {
		if (user == null) {
			throw new IllegalArgumentException();
		}
		User _user = new User(user.getFirstName(), user.getLastName(), user.getEmail(), user.isActive());
		return this.userRepository.save(_user);
	}

	public User updateUser(User user) {
		User _user = this.userRepository.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));

		_user.setFirstName(user.getFirstName());
		_user.setLastName(user.getLastName());
		_user.setEmail(user.getEmail());
		_user.setActive(user.isActive());
		return this.userRepository.save(_user);

	}

	public void deleteUserById(long id) {
		this.userRepository.deleteById(id);
	}

}
