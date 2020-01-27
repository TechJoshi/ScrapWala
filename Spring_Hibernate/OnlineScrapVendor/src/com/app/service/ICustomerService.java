package com.app.service;

import java.util.List;

import com.app.pojos.Order;
import com.app.pojos.User;

public interface ICustomerService {
	public User getCustomer(Integer cid);
	public Order raiseRequest(Order order,Integer cid);
	public List<Order> getOrderList(Integer cid);
	public Order getOrderDetails(Integer oid);
	public Order cancelOrder(Integer oid);
//	public String rateVendor(Integer vid, int rating);
}
