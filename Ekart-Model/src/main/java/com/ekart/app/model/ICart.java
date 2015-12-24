package com.ekart.app.model;

import java.util.List;

 public interface ICart {

	 List<Product> getProducts();

	 void setProducts(List<Product> products);

	 User getUser();

	 void setUser(User user);

	 Long getCartId();

	 void setCartId(Long cartId);

}
