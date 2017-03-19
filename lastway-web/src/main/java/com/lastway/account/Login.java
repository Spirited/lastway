package com.lastway.account;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.lastway.account.dao.LoginDAO;
import com.lastway.service.UserService;
import com.lastway.utils.*;

@Named
@SessionScoped
public class Login implements Serializable {
	private static final long serialVersionUID = 4053950722856666840L;

	@EJB
	private UserService userService;
	
	private String pwd;
	private String msg;
	private String user;
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	public void validateLoginPassword(ActionEvent event) {
		validateLoginPassword();
	}
	
	public String validateLoginPassword() {
		boolean valid = userService.validate(user, pwd);//LoginDAO.validate(user, pwd);

		if ( valid ) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", user);
			
			getUserMainForm(user);
			
			return "admin";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Password", "Please enter correct username and password"));
			return "login";
		}
	}
	
//	public List<User> getUsers() {
//		return userService.findAllUsers();
//	}
	
	private String getUserMainForm(String username) {
		User u = userService.getUser(username);
		
		System.out.println(u);
		System.out.println("====================================");
		System.out.println(u.getGroups());
		
		return "";
	}
	
	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();//ils.getSession();
		session.invalidate();
		System.out.println(user + " logout!");
		
		return "login";
		//return "login?faces-redirect=true";
	}
}
