package com.lastway.service;

import java.util.List;
import java.util.Set;

import com.lastway.account.Group;
import com.lastway.account.User;

public interface UserService {
	User getUser(long id);
	User getUser(String username);
	void createUser(User user);
	Set<Group> getGroups(User user);
	Set<Group> getGroups(long id);
	boolean validate(String login, String password);
	List<User> findAllUsers();
}
