package com.lastway.account.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
