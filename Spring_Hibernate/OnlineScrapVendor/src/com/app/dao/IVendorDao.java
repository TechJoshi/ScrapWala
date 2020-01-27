package com.app.dao;

import java.util.List;

import com.app.pojos.Item;
import com.app.pojos.Order;
import com.app.pojos.OrderDetails;
import com.app.pojos.User;

public interface IVendorDao {
	public User getUser(Integer vid) ;

	public List<Order> pendingOrders(User v);

	public Order getOrder(Integer oid);

	public Order updateOrderStatus(Order o);

	public List<Order> acceptedOrders(User user);

	//public String rateCustomer(User u);

	public Item getItem(Integer itemId);

	public OrderDetails setOrderDetails(OrderDetails orderDetails);
}