package com.lastway.account.test;

import org.junit.Test;

import com.lastway.account.Role;

public class RoleTest extends AbstractPersistentTest {
	@Test
	public void test() {
		System.out.println(em.find(Role.class, 1L));
	}

}
