package com.ekart.app.service;

import java.util.List;

import com.ekart.app.data.exception.UserAlreadyExistException;
import com.ekart.app.model.IUser;
import com.ekart.app.model.Role;
import com.ekart.app.model.User;

 public interface UserService {

	 void createUser(User user) throws UserAlreadyExistException;

	 User getUser(Long id);

	 void deleteUser(Long id);

	 List<User> findAllUsers();

	 User updateUser(Long id, User user);

	 void createRole(Role role);

	 Role updateRole(Long roleId, Role role);
	
	 List<Role> getAllRoles();
	 IUser getByName(String name);
}
