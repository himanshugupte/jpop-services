package com.jpop8.userservice.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpop8.userservice.config.SwaggerConfig;
import com.jpop8.userservice.models.User;
import com.jpop8.userservice.services.UserService;
import com.jpop8.userservice.wrappers.UsersWrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
@Api(tags = { SwaggerConfig.USER_TAG })
public class UserResource {

	private UserService userService;

	public UserResource(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/v1.0")
	@ApiOperation(value = "View a list of users, pass '?name=' to filter by name")
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String name) {
		return new ResponseEntity<>(userService.getAllUsers(name), HttpStatus.OK);
	}

	@GetMapping("/v1.1")
	@ApiOperation(value = "View a list of users, pass '?name=' to filter by name")
	public ResponseEntity<UsersWrapper> getAllUsersV1_1(@RequestParam(required = false) String name) {
		List<User> allUsers = userService.getAllUsers(name);
		UsersWrapper usersWrapper = new UsersWrapper();
		usersWrapper.setUsers(allUsers);
		return new ResponseEntity<>(usersWrapper, HttpStatus.OK);
	}

	@GetMapping({ "/v1.0/{id}", "/v1.1/{id}" })
	@ApiOperation(value = "View a user by id")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		User user = userService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping({ "/v1.0", "/v1.1" })
	@ApiOperation(value = "Create a user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
	}

	@PutMapping({ "/v1.0", "/v1.1" })
	@ApiOperation(value = "Update a user")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
	}

	@DeleteMapping({ "/v1.0/{id}", "/v1.1/{id}" })
	@ApiOperation(value = "Delete a user by id")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
		try {
			this.userService.deleteUserById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
