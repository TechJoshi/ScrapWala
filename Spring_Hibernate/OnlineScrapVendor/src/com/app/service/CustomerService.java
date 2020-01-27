package com.app.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.pojos.Order;
import com.app.pojos.User;
@Transactional
@Service
public class CustomerService implements ICustomerService {


	@Autowired
	private ICustomerDao cdao;
	
	@Override
	public User getCustomer(Integer cid) {
		return cdao.getUser(cid);
	}

	@Override
	public Order raiseRequest(Order o, Integer cid) {
		o.setCustomer(cdao.getUser(cid));
		Date d = new Date();
		o.setRequestDateTime(new Date(d.getTime()));
		o.setVendor(cdao.getUser(6));
		return cdao.raiseRequest(o);
	}

	@Override
	public List<Order> getOrderList(Integer cid) {
		User customer = cdao.getUser(cid);
		
		return cdao.getOrderList(customer);
	}

	@Override
	public Order getOrderDetails(Integer oid) {
		Order o = cdao.getOrderDetails(oid);
		return o;
	}

	@Override
	public Order cancelOrder(Integer oid) {
		
		return cdao.cancelOrder(cdao.getOrderDetails(oid));
	}
//
//	@Override
//	public String rateVendor(Integer vid, int rating) {
//		User u = cdao.getUser(vid);
//		u.setUserRating(rating);
//		return cdao.rateVendor(u);
//	}

}
