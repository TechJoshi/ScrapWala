package com.app.dao;

import com.app.pojos.*;

public interface IUserDao {
	public LoginDetails validateUser(LoginDetails l);
	public User registerUser(User user);
}
