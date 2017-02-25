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
     * @see UserService#getLogin(long)
     */
    public Login getLogin(long id) {
		return entityManager.find(Login.class, id);
    }

	/**
     * @see UserService#getLogin(String)
     */
    public Login getLogin(String username) {
    	System.out.println("+++++++++++++++LoginServiceLocalBean: " + username);
    	
    	Query query = entityManager.createQuery("select u from Login u where u.username = :username");
    	query.setParameter("username", username);
    	Login login = null;
    	try{
    		login = (Login)query.getSingleResult();
    	} catch (NoResultException nre){
    		System.out.println("WARNING: No search result");
    	}
    	
    	if ( login == null )
    		System.out.println("Result null");
    	
		return login;
    }

	@Override
	public void createLogin(Login user) {
		// TODO Auto-generated method stub
		
	}

}
