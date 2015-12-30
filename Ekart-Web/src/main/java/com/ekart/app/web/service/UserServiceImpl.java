package com.ekart.app.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.app.client.EkartWebClient;
import com.ekart.app.model.IUser;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	EkartWebClient client;

	@Override
	public IUser gerUserByName(String name) {
		return client.getUserByName(name);
	}

}
