package com.lastway.service;

import com.lastway.account.User;

public interface UserService {
	User getUser(long id);
	User getUser(String username);
	void createUser(User user);
}
