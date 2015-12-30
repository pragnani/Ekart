package com.ekart.app.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ekart.app.dao.UserDao;
import com.ekart.app.model.Address;
import com.ekart.app.model.IUser;
import com.ekart.app.model.User;

@Repository
public class UserDaoImpl extends AbstractHbnDao<User> implements UserDao {

	@Override
	public IUser getByName(String username) {
		Criteria userCriteria = getSession().createCriteria(IUser.class);
		userCriteria.add(Restrictions.eq("username", username));
		IUser user = (User) userCriteria.uniqueResult();
		return user;
	}

	@Override
	public IUser getByUserAndPassword(String name, String password) {
		Criteria userCriteria = getSession().createCriteria(IUser.class);
		userCriteria.add(Restrictions.eq("username", name));
		userCriteria.add(Restrictions.eq("password", password));
		userCriteria.setFetchMode("roles", FetchMode.JOIN);
		IUser user = (User) userCriteria.uniqueResult();
		return user;
	}

	@Override
	public IUser saveUserAddress(User user, Address address) {
		user.getUserAdress().add(address);
		getSession().save(user);
		return user;
	}

}
