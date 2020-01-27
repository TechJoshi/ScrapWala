package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Order;
import com.app.pojos.OrderStatus;
import com.app.pojos.User;


@Repository
public class CustomerDao implements ICustomerDao{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public User getUser(Integer cid) {
		
		return sf.getCurrentSession().get(User.class, cid);
	}
	@Override
	public Order raiseRequest(Order order) {
		order.setOrderStatus(OrderStatus.REQUESTED);
		sf.getCurrentSession().persist(order);
		return order;
	}
	@Override
	public List<Order> getOrderList(User c) {
		String jpql = "select o from Order o left outer join fetch o.customer where o.customer=:c";
		return sf.getCurrentSession().createQuery(jpql, Order.class).setParameter("c", c).getResultList();
	}
	@Override
	public Order getOrderDetails(Integer oid) {
		return sf.getCurrentSession().get(Order.class, oid);
	}
	@Override
	public Order cancelOrder(Order o) {
		o.setOrderStatus(OrderStatus.CANCELLED);
		sf.getCurrentSession().update(o);
		return o;
	}
//	@Override
//	public String rateVendor(User u) {
//		sf.getCurrentSession().update(u);
//		return "Rating Successfully Done";
//	}
	
	
}
