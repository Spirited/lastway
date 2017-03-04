package com.lastway.account;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.lastway.account.dao.LoginDAO;
import com.lastway.service.UserService;
import com.lastway.utils.SessionUtils;



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

	public String validateLoginPassword() {
		boolean valid = userService.validate(user, pwd);//LoginDAO.validate(user, pwd);

		if ( valid ) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", user);

			return "admin";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Password", "Please enter correct username and password"));
			return "login";
		}
	}

	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();//ils.getSession();
		session.invalidate();
		
		System.out.println(user + " logout!");
		
		return "login";
	}
}
