package com.lastway.account.dao;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lastway.account.User;
import com.lastway.service.UserService;

public class LoginDAO {
	@PersistenceContext(name="lastway")
	private EntityManager entityManager;
	
//	@EJB
//	private static UserService userService;
	
	public static boolean validate(String user, String password) {
	//userService.getUser(user);
		
		return true;
	}
}
