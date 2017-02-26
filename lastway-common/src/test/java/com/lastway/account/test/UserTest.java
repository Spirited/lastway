package com.lastway.account.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lastway.account.User;

public class UserTest extends AbstractPersistentTest {	
	@Test
	public void test() {
		User user1 = em.find(User.class, new Long(1));
		System.out.println(user1.getLogin());
		System.out.println(user1.getLastName());
		System.out.println(user1.getGroups());
	}
}
