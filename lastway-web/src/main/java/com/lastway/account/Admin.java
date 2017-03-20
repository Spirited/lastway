package com.lastway.account;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.inject.Named;
import javax.naming.Name;

import com.lastway.service.UserService;

@Named
@SessionScoped
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<User> users;
	
	private User selectedUser;
	
	@EJB
	private UserService userService;
	
	@PostConstruct
	public void init() {
		users = userService.findAllUsers();
		System.out.print("Invoke from JSF: ");
		users.forEach(u->System.out.println(u));
	}
	
	
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
//	public User getSelectedUser() {
//		User[] temp = new User[users.size()];
//		temp = users.toArray(temp);
//		
//		//System.out.println("Selected User Detail: " + temp);
//		
//		DataModel<User> model = new ArrayDataModel<>(temp);
//		User userDetails = model.getRowData();
//		System.out.println("Selected user: " + userDetails);
//		return userDetails;
//	}
//	
	public User getSelectedUser() {
		System.out.println("Selected User: " + selectedUser);
		return selectedUser;
	}
	
	public void setSelectedUser(User selectedUser) {
		System.out.println("SET select user: " + selectedUser);
		this.selectedUser = selectedUser;
	}
}
