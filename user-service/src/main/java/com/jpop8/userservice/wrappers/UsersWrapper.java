package com.jpop8.userservice.wrappers;

import java.util.ArrayList;
import java.util.List;

import com.jpop8.userservice.models.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UsersWrapper {
	private List<User> users;

	public UsersWrapper() {
		users = new ArrayList<>();
	}
}
