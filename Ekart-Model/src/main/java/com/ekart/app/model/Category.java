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
import javax.persistence.OneToMany;

@Entity
public class Category extends AbstractEntity implements ICategory {

	
	@Id
    @Column(name="category_id")
    @GeneratedValue
    private Long category_id;
     
	
	@ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="maincategory_id")
	Category mainCategory;
	
	@OneToMany(mappedBy="mainCategory")
	Set<Category> subCategories = new HashSet<>(0);

}
