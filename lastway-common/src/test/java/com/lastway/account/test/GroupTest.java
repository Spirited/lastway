package com.lastway.account.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lastway.account.Group;

public class GroupTest extends AbstractPersistentTest {
	
	@Test
	public void test() {
		System.out.println(em.find(Group.class, new Long(1)));
	}
	
	@Test
	public void createGroup() {
		/*Group systemManager = new Group("System manager", "Operates and support user provisioning");
		tx.begin();
		em.persist(systemManager);
		tx.commit();*/
		
		Group systemManager = em.find(Group.class, 4L);
		assertEquals(4L, systemManager.getId());
	}
}
