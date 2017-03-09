package com.lastway.account;


import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUtil;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lastway.service.UserService;
import com.lastway.account.User;


@Stateless
@Local//(LoginService.class)
//@Remote
public class UserServiceLocalBean implements UserService {
	private static Logger log = LoggerFactory.getLogger(UserServiceLocalBean.class);

	@PersistenceContext(unitName="lastway")
	//@PersistenceUnit(name="lastway")
	private EntityManager entityManager;

	public UserServiceLocalBean() {

	}

	private void updateLoginTime(long id) {
		Query query = entityManager.createQuery("UPDATE " + User.class.getName() + " SET last_login=sysdate() WHERE id = :id");
		query.setParameter("id", id);
		
		query.executeUpdate();
	}
	
	@Override
	public boolean validate(String login, String password) {
		if ( login.equals("") || login == null ) {
			log.debug("Login field is empty");
			System.out.println("Login field is empty");
			return false;
		}
		
		if ( password.equals("") || password == null ) {
			System.out.println("Login field is empty");
			return false;
		}
		
		try {
			Query query = entityManager.createQuery("SELECT u FROM " + User.class.getName() + " u WHERE u.login = :login");
			query.setParameter("login", login);
			User user = (User)query.getSingleResult();
			
			if ( !user.getPassword().equals(password) )
				return false;
			
			updateLoginTime(user.getId());
			
			return true;
		} catch (NoResultException e) {
			System.out.println("WARNING: User with ["+ login +"] doesn't exist!");
			return false;
		}
	}

	@Override
	public User getUser(long id) {
		PersistenceUtil persistenceUtil = Persistence.getPersistenceUtil();
		if ( persistenceUtil == null )
			System.out.println("==== persistenceUtil is null ====");
		else
			System.out.println("#### persistenceUtil is NOT null ####");


		User user = null;
		try {
			Query query = entityManager.createQuery("SELECT u FROM " + User.class.getName() + " u WHERE u.id = :id");
			query.setParameter("id", id);
			//user = entityManager.find(User.class, id);
			user = (User)query.getSingleResult();
			System.out.println(user.getMsisdn());
			//entityManager.detach(user);
		} catch (NoResultException nre){
			System.out.println("WARNING: No search result");
		}

		return user;
	}

	public User getUser(String username) {
		/*System.out.println("+++++++++++++++LoginServiceLocalBean: " + username); */
		
		
    	Query query = entityManager.createQuery("select u from " + User.class.getName() + " u where u.login = :username");
    	query.setParameter("username", username);
    	User user = null;
    	try{
    		user = (User)query.getSingleResult();
    	} catch (NoResultException nre){
    		System.out.println("WARNING: No search result");
    	}

    	if ( user == null ) 
    		System.out.println("Result null");
    	

		return user;
	}

	@Override
	public void createUser(User user) {


	}


	@Override
	public Set<Group> getGroups(User user) {
		return user.getGroups();
	}


	@Override
	public Set<Group> getGroups(long id) {
		return getUser(id).getGroups();
	}

}
