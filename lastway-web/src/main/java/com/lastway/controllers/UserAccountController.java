package com.lastway.controllers;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.validation.constraints.Size;

import com.lastway.service.UserService;

@Named
@SessionScoped
public class UserAccountController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2162291301700501657L;

	@EJB
	private UserService userService;
	
	@Size(min=5, max = 30, message="{step1_usernameSize}")
	private String username;
	private String password;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String goToLoginPage() {
		SecurityManager s = new SecurityManager();
		
		/*PersistenceUtil persistenceUtil = Persistence.getPersistenceUtil();
    	if ( persistenceUtil == null )
    		System.out.println("=="+UserAccountController.class.getName()+"== persistenceUtil is null ====");
    	else
    		System.out.println("##"+UserAccountController.class.getName()+"## persistenceUtil is NOT null ####");
		
		User user = userService.getUser(1L);
		
		System.out.println("load: " + persistenceUtil.isLoaded(user));
		//System.out.println(user.getId() + ": " + user);
		//System.out.println("Groups: " + user.getGroups());
*/		
		return "login";
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String buttonAction(ActionEvent actionEvent) {
        //addMessage("Welcome to Primefaces!!");
        return goToAdminForm();
    }
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        
        System.out.println(FacesContext.getCurrentInstance().getCurrentPhaseId());
    }
	
	public String goToAdminForm() {
		addMessage("Admin Panel");
		System.out.println("goToAdminForm invoked");
		return "admin";
	}
	
	public void displayAdminUsername() {
		System.out.println("Username:" + (userService==null));
		System.out.println("Username:" + username);
		//User user = userService.getUser(username);//.getLogin();		
		
		/*if ( login == null ) {
			FacesContext.getCurrentInstance().addMessage("null", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "User Saved"));
	        username = null;
	        email = null;
			return "index";
		}
		FacesContext.getCurrentInstance().addMessage("not null)", new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", login.getLogin()));
		return login.getLogin();*/
	}
}
