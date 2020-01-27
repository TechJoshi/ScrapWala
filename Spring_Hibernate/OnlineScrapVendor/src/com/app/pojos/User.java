package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User {
	private Integer id;
	private String userName;
	private long userPhone;
	private String userEmail;
	private String userPassword;
	//private Integer userRating;
	private UserType userRole;
	private LoginDetails loginDetails;
	@JsonIgnore
	private List<Order> customerOrderList = new ArrayList<>(); 
	@JsonIgnore
	private List<Order> vendorOrderList = new ArrayList<>();
	 

	public User() {	}

	

	public User(String userName, long userPhone, String userEmail, String userPassword/*, Integer userRating*/,UserType userRole) {
		super();
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		//this.userRating = userRating;
		this.userRole = userRole;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "user_name",length = 30)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(nullable = false,name = "user_phone")
	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	@Column(name = "user_email",length = 30,nullable = false)
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



//	@Column(name = "user_rating")
//	public Integer getUserRating() {
//		return userRating;
//	}
//
//	public void setUserRating(Integer userRating) {
//		this.userRating = userRating;
//	}


	@JsonIgnore
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	public LoginDetails getLoginDetails() {
		return loginDetails;
	}


	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}
	
	
	@OneToMany(mappedBy = "customer"/* ,fetch = FetchType.EAGER */,cascade = CascadeType.ALL,orphanRemoval =
	  true) public List<Order> getCustomerOrderList() { return customerOrderList; }
	  
	  
	  public void setCustomerOrderList(List<Order> customerOrderList) {
	  this.customerOrderList = customerOrderList; }
	  
	  
	@OneToMany(mappedBy = "vendor", /* fetch = FetchType.EAGER, */cascade = CascadeType.ALL,orphanRemoval =
	  true) public List<Order> getVendorOrderList() { return vendorOrderList; }
	  
	  
	  public void setVendorOrderList(List<Order> vendorOrderList) {
	  this.vendorOrderList = vendorOrderList; }
	 
	@Enumerated(EnumType.STRING)
	@Column(name = "user_role",length = 30)
	public UserType getUserRole() {
		return userRole;
	}

	public void setUserRole(UserType userRole) {
		this.userRole = userRole;
	}

	public void addLoginDetails(LoginDetails l) {
		//user-->loginDetails
		this.loginDetails = l;
		l.setUser(this);//loginDetails-->user
	}
	
	public void removeLoginDetails(LoginDetails l) {
		loginDetails = null;
		l.setUser(null);
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPhone=" + userPhone + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + ",  userRole=" + userRole + "]";
	}



	
}
