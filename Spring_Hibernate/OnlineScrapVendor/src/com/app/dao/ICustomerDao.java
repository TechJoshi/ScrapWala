package com.app.dao;

import java.util.List;

import com.app.pojos.*;

public interface ICustomerDao {
	public User getUser(Integer cid);
	public Order raiseRequest(Order order);
	public List<Order> getOrderList(User customer);
	public Order getOrderDetails(Integer oid);
	public Order cancelOrder(Order order);
	//public String rateVendor(User u);
}
