package com.lastway.account.test;

import org.junit.Test;

import com.lastway.account.Group;

public class GroupTest extends AbstractPersistentTest {
	
	@Test
	public void test() {
		System.out.println(em.find(Group.class, new Long(1)));
	}
}
