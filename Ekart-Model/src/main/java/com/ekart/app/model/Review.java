package com.ekart.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Review implements IReview{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewId;
	
	@OneToOne
	private User reviewer;
	@OneToOne
	private Product product;

	private String subject;

	private String description;
	private Integer stars;

	public User getReviewer() {
		return reviewer;
	}

	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

}
