package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orders")
public class Order {
	private Integer id;
	private String pickupAddress,pickupCity,pickupState;
	private int pickupZipCode;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+5:30")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pickupDate;
	@JsonFormat(pattern = "HH:mm",timezone = "GMT+5:30")
	@DateTimeFormat(pattern = "HH:mm")
	private Date pickupTime;
	private OrderStatus orderStatus;
	private int otp;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+5:30")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date requestDateTime;
	private User customer;
	private User vendor;
	@JsonIgnore
	private List<OrderDetails> orderDetails = new ArrayList<>();
	
	
	public Order() { }

	public Order(String pickupAddress, String pickupCity, String pickupState, int pickupZipCode, Date pickupDate,
			Date pickupTime, OrderStatus orderStatus, int otp, Date requestDateTime) {
		super();
		this.pickupAddress = pickupAddress;
		this.pickupCity = pickupCity;
		this.pickupState = pickupState;
		this.pickupZipCode = pickupZipCode;
		this.pickupDate = pickupDate;
		this.pickupTime = pickupTime;
		this.orderStatus = orderStatus;
		this.otp = otp;
		this.requestDateTime = requestDateTime;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "pickup_address",length = 128)
	public String getPickupAddress() {
		return pickupAddress;
	}

	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}

	@Column(name = "pickup_city",length = 30)
	public String getPickupCity() {
		return pickupCity;
	}

	public void setPickupCity(String pickupCity) {
		this.pickupCity = pickupCity;
	}

	@Column(name = "pickup_state",length = 30)
	public String getPickupState() {
		return pickupState;
	}

	public void setPickupState(String pickupState) {
		this.pickupState = pickupState;
	}

	@Column(name = "pickup_zip_code")
	public int getPickupZipCode() {
		return pickupZipCode;
	}

	public void setPickupZipCode(int pickupZipCode) {
		this.pickupZipCode = pickupZipCode;
	}

	@Temporal(TemporalType.DATE)
	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	@Temporal(TemporalType.TIME)
	public Date getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "order_status",length = 20)
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "OTP")
	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getRequestDateTime() {
		return requestDateTime;
	}

	public void setRequestDateTime(Date requestDateTime) {
		this.requestDateTime = requestDateTime;
	}

	@ManyToOne
	@JoinColumn(name = "cust_id")
	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	
	@ManyToOne  
	@JoinColumn(name = "vendor_id") 
	public User getVendor() { return vendor; }	  
	public void setVendor(User vendor) { this.vendor = vendor; }
 
	
	@OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", pickupAddress=" + pickupAddress + ", pickupCity=" + pickupCity + ", pickupState="
				+ pickupState + ", pickupZipCode=" + pickupZipCode + ", pickupDate=" + pickupDate + ", pickupTime="
				+ pickupTime + ", orderStatus=" + orderStatus + ", otp=" + otp + ", requestDateTime=" + requestDateTime
				+ "]";
	}
	
	
	
}
