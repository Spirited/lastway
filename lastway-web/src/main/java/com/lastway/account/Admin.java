package com.lastway.account;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

import com.lastway.service.UserService;

@Named
@SessionScoped
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<User> users;
	
	@EJB
	private UserService userService;
	
	@PostConstruct
	public void init() {
		users = userService.findAllUsers();
		System.out.println(users);
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public List<User> getUsers() {
		return users;
	}
}
