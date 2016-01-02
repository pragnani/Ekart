package com.ekart.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@NamedQueries(  
        {  
            @NamedQuery(  
            name = "findMainCategories",  
            query = "from Category c where c.mainCategory = NULL"  
            )  
        }  
    ) 

@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity
public class Category extends AbstractEntity implements ICategory {

	
	@Id
    @Column(name="category_id")
    @GeneratedValue
    private Long id;
	
	@Column(name="category_name")
	private String name;
     
	
	@ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="maincategory_id")
	Category mainCategory;
	
	

	@OneToMany(mappedBy="mainCategory")
	Set<Category> subCategories = new HashSet<>(0);
	
	@OneToMany(mappedBy="category")
	Set<Product> products= new HashSet<>(0); 
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mainCategory
	 */
	public Category getMainCategory() {
		return mainCategory;
	}

	/**
	 * @param mainCategory the mainCategory to set
	 */
	public void setMainCategory(Category mainCategory) {
		this.mainCategory = mainCategory;
	}

	/**
	 * @return the subCategories
	 */
	public Set<Category> getSubCategories() {
		return subCategories;
	}

	/**
	 * @param subCategories the subCategories to set
	 */
	public void setSubCategories(Set<Category> subCategories) {
		this.subCategories = subCategories;
	}

	/**
	 * @return the products
	 */
	public Set<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
