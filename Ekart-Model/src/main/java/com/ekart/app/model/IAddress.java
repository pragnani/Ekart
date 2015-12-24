package com.ekart.app.model;

 public interface IAddress {

	 void setStreet(String street);

	 String getStreet();

	 String getCity();

	 void setCity(String city);

	 String getState();

	 void setState(String state);

	 String getZipcode();

	 void setZipcode(String zipcode);

	 User getUser();

	 void setUser(User user);
	
	 Long getAddressId() ;

	 void setAddressId(Long addressId);


}
