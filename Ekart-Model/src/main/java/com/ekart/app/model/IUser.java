package com.ekart.app.model;

import java.util.List;

public interface IUser {

	void setEnabled(boolean enabled);

	boolean isEnabled();

	String getName();

	void setName(String name);

	String getEmail();

	void setEmail(String email);

	String getPassword();

	void setPassword(String password);

	Cart getCart();

	void setCart(Cart cart);

	List<Address> getUserAdress();

	void setUserAdress(List<Address> userAdress);

	void setUserId(Long userid);

	Long getUserId();

	 List<Role> getRoles() ;

	 void setRoles(List<Role> roles) ;

}
