package com.ekart.app.dao.hibernate;

import com.ekart.app.dao.CartDao;
import com.ekart.app.model.ICart;
import com.ekart.app.model.User;

public class CartDaoImpl extends AbstractHbnDao<ICart> implements CartDao<ICart> {

	@Override
	public ICart getCart(User user) {
		return get(user.getCart().getCartId());
	}

}
