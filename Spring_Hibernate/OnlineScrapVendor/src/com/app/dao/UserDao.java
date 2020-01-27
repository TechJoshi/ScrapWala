package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.*;

@Transactional
@Repository
public class UserDao implements IUserDao
{
	@Autowired
	SessionFactory sf;

	@Override
	public LoginDetails validateUser(LoginDetails l) {
		System.out.println(l);
		String jpql = "select l from LoginDetails l where l.userEmail=:em and l.userPassword=:pass";
		return sf.getCurrentSession().createQuery(jpql, LoginDetails.class).setParameter("em",l.getUserEmail()).setParameter("pass", l.getUserPassword()).getSingleResult();
	}

	@Override
	public User registerUser(User user) {
		sf.getCurrentSession().persist(user);
		LoginDetails l = new LoginDetails(user.getUserEmail(), user.getUserPassword(), user.getUserRole());
		user.addLoginDetails(l);
		return user;
	}

}
