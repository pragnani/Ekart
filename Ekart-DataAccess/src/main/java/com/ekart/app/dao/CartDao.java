package com.ekart.app.dao;

import com.ekart.app.model.User;

public interface CartDao<ICart> extends Dao<ICart>{
	
	ICart getCart(User user);

}
