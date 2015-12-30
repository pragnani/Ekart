package com.ekart.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ekart.app.dao.RoleDao;
import com.ekart.app.dao.UserDao;
import com.ekart.app.data.exception.UserAlreadyExistException;
import com.ekart.app.model.IUser;
import com.ekart.app.model.Role;
import com.ekart.app.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	RoleDao roleDao;

	@Override
	public void createUser(User user) throws UserAlreadyExistException {
		try {

			userDao.create(user);
		} catch (Exception e) {
			throw new UserAlreadyExistException(e.getMessage());
		}
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(Long id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createRole(Role role) {
		roleDao.create(role);
	}

	@Override
	public Role updateRole(Long roleId, Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getAllRoles() {
		return roleDao.getAll();
	}

	@Override
	public IUser getByName(String name) {
		
		return userDao.getByName(name);
	}

	@Override
	public IUser getByUserNameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.getByUserAndPassword(username, password);
	}

}
