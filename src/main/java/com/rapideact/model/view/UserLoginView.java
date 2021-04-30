package com.rapideact.model.view;

import java.io.Serializable;

import com.rapideact.model.entity.UserDto;

public class UserLoginView implements Serializable {
	
	private UserDto user;

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

}
