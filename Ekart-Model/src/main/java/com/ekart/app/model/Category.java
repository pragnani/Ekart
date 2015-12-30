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

@NamedQueries(  
        {  
            @NamedQuery(  
            name = "findMainCategories",  
            query = "from Category c where c.mainCategory = NULL"  
            )  
        }  
    )  
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

}
