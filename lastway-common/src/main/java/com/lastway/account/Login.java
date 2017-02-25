package com.lastway.account;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.org.apache.xml.internal.security.utils.Base64;

@Entity
@Table(name = "login")
public class Login implements Serializable {
	private static final Logger log = LoggerFactory.getLogger(Login.class);
	
	@Id
	@Column(name="login_id")
	private long id;
	
	@Column
	private String username;
	@Column
	private String login;
	@Column
	private String password;
	@Column
	private String active;
	
	@Temporal(TemporalType.DATE)
	private Date register_date;
	
	@Temporal(TemporalType.DATE)
	private Date modified_date;
	
	/*@OneToOne
	private Role role;
	
	@OneToOne
	private Group group;*/
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Group> groups = new HashSet<>();
	//private long group_id;
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes("UTF-8"));
			byte[] digest = md.digest();
			String encodedPassword = Base64.encode(digest);
			this.password = encodedPassword;
		} catch (NoSuchAlgorithmException e) {
			log.warn("Password creation failed",e);
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			log.warn("Password creation failed",e);
			throw new RuntimeException(e);
		}
		
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
}
