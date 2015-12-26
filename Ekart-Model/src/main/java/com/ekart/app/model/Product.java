package com.ekart.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product extends AbstractEntity implements IProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	String productName;
	String productPrice;
	Integer discount;
	Double price;
	Double threadShouldPrice;
	String properties;
	
	@OneToMany
	List<User> merchents;
	
	@OneToMany
	List<Review> reviews;
	
	boolean isSpecial;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getThreadShouldPrice() {
		return threadShouldPrice;
	}

	public void setThreadShouldPrice(Double threadShouldPrice) {
		this.threadShouldPrice = threadShouldPrice;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public List<User> getMerchents() {
		return merchents;
	}

	public void setMerchents(List<User> merchents) {
		this.merchents = merchents;
	}

	public boolean isSpecial() {
		return isSpecial;
	}

	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}
