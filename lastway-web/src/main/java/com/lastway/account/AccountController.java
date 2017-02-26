package com.lastway.account;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import com.lastway.service.UserService;

@Named
@SessionScoped
public class AccountController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2162291301700501657L;

	@EJB
	private UserService userService;
	
	private String username;
	private String password;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String goToLoginPage() {
		System.out.println(userService.getUser(1));
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
		User user = userService.getUser(username);//.getLogin();		
		
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
