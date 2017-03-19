package com.lastway.account.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.PersistenceContext;

import org.junit.Test;

import com.lastway.account.Group;
import com.lastway.account.User;

public class UserTest extends AbstractPersistentTest {	
	@Test
	public void test() {
		User user1 = em.find(User.class, new Long(1));
		System.out.println("Login: " + user1.getLogin());
		System.out.println("LastName: " + user1.getLastName());
		System.out.println("Groups: " + user1.getGroups());
	}
	//@Test
	public void createUserTest() {
		User user = new User("Komsomol_1917", "Lenin", "Vladimir", "Illich", "lenin@mavsoley.ru", "046667898");
		Group systemManager = em.find(Group.class, 4L);
		
		assertNotNull(systemManager);
		assertEquals("System manager", systemManager.getName());
		
		Set<Group> groups = new HashSet<>();
		groups.add(systemManager);
		user.setGroups(groups);
		
		tx.begin();
		em.persist(user);
		em.persist(systemManager);
		tx.commit();
		
		
		/*Query query = em.createQuery("SELECT u FROM User u");
		List<User> users = (List<User>)query.getResultList();
		users.forEach(u->System.out.println(u));*/
		
		/*Query query = em.createQuery("SELECT u FROM users u WHERE u.login = :login");
    	query.setParameter("login", "Komsomol_1917");*/
    	
    	/*User lenin = null;
    	try{
    		lenin = (User)query.getSingleResult();
    	} catch (NoResultException nre){
    		System.out.println("WARNING: No search result");
    	}
		
		assertEquals("Lenin", lenin.getLastName());*/
	}
	
	@Test
	public void deleteUserTest() {
		
	}
}
