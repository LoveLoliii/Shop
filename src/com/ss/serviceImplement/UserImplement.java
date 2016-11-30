package com.ss.serviceImplement;

import com.ss.dao.UserDAO;
import com.ss.pojo.User;
import com.ss.service.UserService;

public class UserImplement implements UserService{

	@Override
	public User login(User u) {
		UserDAO userDao = new UserDAO(); 
		u = userDao.query(u);
		return  u;
	}

}
