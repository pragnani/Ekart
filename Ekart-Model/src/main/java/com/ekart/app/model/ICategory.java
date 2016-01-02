package com.ekart.app.model;

import java.util.Set;

public interface ICategory {

	/**
	 * @return the id
	 */
	Long getId();

	/**
	 * @param id
	 *            the id to set
	 */
	void setId(Long id);

	/**
	 * @return the name
	 */
	String getName();

	/**
	 * @param name
	 *            the name to set
	 */
	void setName(String name);

	/**
	 * @return the mainCategory
	 */
	Category getMainCategory();

	/**
	 * @param mainCategory
	 *            the mainCategory to set
	 */
	void setMainCategory(Category mainCategory);

	/**
	 * @return the subCategories
	 */
	Set<Category> getSubCategories();

	/**
	 * @param subCategories
	 *            the subCategories to set
	 */
	void setSubCategories(Set<Category> subCategories);

	/**
	 * @return the products
	 */
	Set<Product> getProducts();

	/**
	 * @param products
	 *            the products to set
	 */
	void setProducts(Set<Product> products);

}
