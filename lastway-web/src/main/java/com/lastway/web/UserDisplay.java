package com.lastway.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lastway.account.User;
import com.lastway.service.UserService;

@Named
@SessionScoped
public class UserDisplay implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Logger log = LoggerFactory.getLogger(UserDisplay.class);
	
	private User user;
	
	private void checkCredentials() {
		String remoteUser = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		System.out.println("REMOTE USER:: " + remoteUser);
		if ( remoteUser != null ) {
			Context ctx = null;
			try {
				ctx = new InitialContext();
				UserService us = (UserService) ctx.lookup("java:global/lastway-ear/lastway-ejb-1.0-SNAPSHOT/UserServiceLocalBean");
				user = us.getUser(remoteUser);
			} catch (NamingException e) {
				//log.warn("Unable to retrieve the UserServiceBean.",e);
				System.out.println("Unable to retrieve the UserServiceBean.");
			} finally {
				if ( ctx != null ) try { ctx.close(); } catch ( Throwable e ) {}
			}
		} else {
			instantiateGuestInstance();
		}
	}
	
	private void instantiateGuestInstance() {
		user = new User();
	}
	
	public User getUser() {
		checkCredentials();
		return user;
	}
	
	public boolean isGuest() {
		checkCredentials();
		return user == null;
	}
	
	public void logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
}
