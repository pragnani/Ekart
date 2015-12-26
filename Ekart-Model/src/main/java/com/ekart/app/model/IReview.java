package com.ekart.app.model;

 public interface IReview {

	 User getReviewer();

	 void setReviewer(User reviewer);

	 Product getProduct();

	 void setProduct(Product product);

	 String getSubject();

	 void setSubject(String subject);

	 String getDescription();

	 void setDescription(String description);

	 Integer getStars();

	 void setStars(Integer stars);
	 Long getReviewId() ;

	 void setReviewId(Long reviewId) ;


}
