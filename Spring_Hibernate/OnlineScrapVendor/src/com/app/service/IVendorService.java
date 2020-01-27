package com.app.service;

import java.util.List;

import com.app.pojos.*;

public interface IVendorService {
	List<Order> pendingOrders(Integer vid);

	Order acceptOrder(Integer oid);

	Order rejectOrder(Integer oid);

	List<Order> acceptedOrders(Integer vid);

	//String rateCustomer(Integer cid, int rating);

	Order verifyOTP(Integer oid);

	OrderDetails setOrderDetails(OdrDtls od);

	Order SuccessOrder(Integer oid);

	Order cancelOrder(Integer oid);

	
}
