package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "login_details")
public class LoginDetails {

	private String userEmail;
	private String userPassword;
	private UserType userRole;
	private User user;
	
	public LoginDetails() { }
	
	
	public LoginDetails(String userEmail, String userPassword, UserType userRole) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userRole = userRole;
	}

	@Id
	@Column(name = "user_email",length = 30)
	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	@Column(name = "user_password",length = 20)
	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	@Enumerated(EnumType.STRING)
	@Column(name = "user_role",length = 30)
	public UserType getUserRole() {
		return userRole;
	}

	public void setUserRole(UserType userRole) {
		this.userRole = userRole;
	}
	
	
	@OneToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "LoginDetails [userEmail=" + userEmail + ", userPassword=" + userPassword + ", userRole=" + userRole
				+ "]";
	}

	
	
}
