package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.pojos.OdrDtls;
import com.app.pojos.Order;
import com.app.pojos.OrderDetails;
import com.app.pojos.OrderStatus;

@Transactional
@Service
public class VendorService implements IVendorService {

	@Autowired
	IVendorDao vdao;
	@Override
	public List<Order> pendingOrders(Integer vid) {
		
		return vdao.pendingOrders(vdao.getUser(vid));
	}
	@Override
	public Order acceptOrder(Integer oid) {
		Order o = vdao.getOrder(oid);
		o.setOrderStatus(OrderStatus.APPROVED);
		return vdao.updateOrderStatus(o);
	}
	@Override
	public Order rejectOrder(Integer oid) {
		Order o = vdao.getOrder(oid);
		o.setOrderStatus(OrderStatus.REJECTED);
		return vdao.updateOrderStatus(o);
	}
	@Override
	public List<Order> acceptedOrders(Integer vid) {
	
		return vdao.acceptedOrders(vdao.getUser(vid));
	}
//	@Override
//	public String rateCustomer(Integer cid, int rating) {
//		User u = vdao.getUser(cid);
//		u.setUserRating(rating);
//		return vdao.rateCustomer(u);
//	}
	@Override
	public Order verifyOTP(Integer oid) {
		Order o = vdao.getOrder(oid);
		return o;
	}
	@Override
	public OrderDetails setOrderDetails(OdrDtls od) {
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setItem(vdao.getItem(od.getItemId()));
		orderDetails.setOrder(vdao.getOrder(od.getOrdId()));
		orderDetails.setQuantity(od.getQuantity());
		return vdao.setOrderDetails(orderDetails);
	}
	@Override
	public Order SuccessOrder(Integer oid) {
		Order o = vdao.getOrder(oid);
		o.setOrderStatus(OrderStatus.SUCCEED);
		return vdao.updateOrderStatus(o);
	}
	@Override
	public Order cancelOrder(Integer oid) {
		Order o = vdao.getOrder(oid);
		o.setOrderStatus(OrderStatus.CANCELLED);
		return vdao.updateOrderStatus(o);
	}
	

}
