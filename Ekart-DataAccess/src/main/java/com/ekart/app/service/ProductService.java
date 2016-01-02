package com.ekart.app.service;

import java.util.List;

import com.ekart.app.model.Category;
import com.ekart.app.model.Product;

public interface ProductService {

	List<Category> getAllMainCategories();

	Category addCategory(Category category);

	Product addProduct(Product product);
	
	List<Product> getProductByCategory(Long categoryId);

}
