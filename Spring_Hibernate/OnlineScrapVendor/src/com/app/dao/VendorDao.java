package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Item;
import com.app.pojos.Order;
import com.app.pojos.OrderDetails;
import com.app.pojos.User;

@Repository
public class VendorDao implements IVendorDao {

	@Autowired
	private SessionFactory sf;
	@Override
	public User getUser(Integer vid) {
		return sf.getCurrentSession().get(User.class, vid);
	}
	@Override
	public List<Order> pendingOrders(User v) {
		String jpql = "select o from Order o left outer join fetch o.vendor where o.vendor=:vend and o.orderStatus='REQUESTED'";
		return sf.getCurrentSession().createQuery(jpql, Order.class).setParameter("vend", v).getResultList();
	}
	@Override
	public Order getOrder(Integer oid) {
		return sf.getCurrentSession().get(Order.class, oid);
	}
	@Override
	public Order updateOrderStatus(Order o) {
		sf.getCurrentSession().update(o);
		return o;
	}
	@Override
	public List<Order> acceptedOrders(User v) {
		String jpql = "select o from Order o left outer join fetch o.vendor where o.vendor=:vend and o.orderStatus='APPROVED'";
		return sf.getCurrentSession().createQuery(jpql, Order.class).setParameter("vend", v).getResultList();
	}
//	@Override
//	public String rateCustomer(User u) {
//		sf.getCurrentSession().update(u);
//		return "Rating Successfully Done";
//	}
	@Override
	public Item getItem(Integer itemId) {
		return sf.getCurrentSession().get(Item.class, itemId);
	}
	@Override
	public OrderDetails setOrderDetails(OrderDetails orderDetails) {
		sf.getCurrentSession().persist(orderDetails);
		return orderDetails;
	}
}
