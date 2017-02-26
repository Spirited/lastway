package com.lastway.account;


import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lastway.service.UserService;

/**
 * Session Bean implementation class UserServiceBean
 */
@Stateless
@Local//(LoginService.class)
public class UserServiceLocalBean implements UserService {
	private static Logger log = LoggerFactory.getLogger(UserServiceLocalBean.class);
	
	@PersistenceContext(unitName="lastway")
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public UserServiceLocalBean() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see UserService#getUser(long)
     */
    
    public User getUser(long id) {
		return entityManager.find(User.class, id);
    }

	/**
     * @see UserService#getUser(String)
     */
    public User getUser(String username) {
    	System.out.println("+++++++++++++++LoginServiceLocalBean: " + username);
    	
    	Query query = entityManager.createQuery("select u from Login u where u.username = :username");
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
		// TODO Auto-generated method stub
		
	}

}
