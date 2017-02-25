package com.lastway.service;

import javax.ejb.Remote;

import com.lastway.account.Login;

public interface UserService {
	Login getLogin(long id);
	Login getLogin(String username);
	void createLogin(Login user);
}