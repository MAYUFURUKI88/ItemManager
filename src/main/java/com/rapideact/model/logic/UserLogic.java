package com.rapideact.model.logic;

import com.rapideact.model.dao.UserDao;
import com.rapideact.model.view.UserLoginView;

public class UserLogic {

	public UserLoginView setUserView(String id, String password) {
		UserLoginView userView = new UserLoginView();

		UserDao userDao = new UserDao();

		userView.setUser(userDao.findUser(id, password));

		return userView;
	}

}
