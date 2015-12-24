package com.ekart.app.dao;

import com.ekart.app.model.IUser;
import com.ekart.app.model.User;


public interface UserDao extends Dao<User>{

	IUser getByName(String name);
	IUser getByUserAndPassword(String name, String password);
}
