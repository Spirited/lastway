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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.org.apache.xml.internal.security.utils.Base64;

@Entity
@Table(name="USERS")
public class User implements Serializable {
	private static final Logger log = LoggerFactory.getLogger(User.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="user_id")
	private long id;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="name")
	private String name;
	
	@Column(name="patronymic")
	private String patronymic;
	
	@Column(name="email")
	private String email;
	
	@Column(name="skype")
	private String skype;
	
	@Column(name="msisdn")
	private String msisdn;
	
	@Column
	private String login;
	@Column
	private String password;
	@Column
	private char active;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date register_date;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified_date;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_login;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "jnd_user_groups",
			joinColumns = @JoinColumn(name = "user_fk"),
			inverseJoinColumns = @JoinColumn(name = "group_fk"))
	private Set<Group> groups = new HashSet<>();
	
	public User() {	}
	
	public User(String lastName, String name, String patronymic, String email, String msisdn) {
		this.lastName = lastName;
		this.name = name;
		this.patronymic = patronymic;
		this.email = email;
		this.msisdn = msisdn;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public char getActive() {
		return active;
	}

	public void setActive(char active) {
		this.active = active;
	}

	public Date getRegister_date() {
		return register_date;
	}

	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}

	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}
	
	public static void main(String[] args) {
		
	}
}
