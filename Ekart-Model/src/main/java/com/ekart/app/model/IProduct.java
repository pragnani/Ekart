package com.ekart.app.model;

import java.util.List;

 public interface IProduct {
	 void setProductName(String productName);

	 String getProductPrice();

	 void setProductPrice(String productPrice);

	 Integer getDiscount();

	 void setDiscount(Integer discount);

	 Double getPrice();

	 void setPrice(Double price);

	 Double getThreadShouldPrice();

	 void setThreadShouldPrice(Double threadShouldPrice);

	 String getProperties();

	 void setProperties(String properties);

	 List<User> getMerchents();

	 void setMerchents(List<User> merchents);

	 boolean isSpecial();

	 void setSpecial(boolean isSpecial);

	 Long getProductId();

	 void setProductId(Long productId);
	
	 List<Review> getReviews() ;

	 void setReviews(List<Review> reviews);

}
