package com.ekart.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.app.dao.CategoryDao;
import com.ekart.app.dao.ProductDao;
import com.ekart.app.model.Category;
import com.ekart.app.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	ProductDao productDao;

	@Override
	public List<Category> getAllMainCategories() {
		return categoryDao.findAllMainCategories();
	}

	@Override
	public Category addCategory(Category category) {
		categoryDao.create(category);
		return category;
	}

	@Override
	public Product addProduct(Product product) {
		productDao.create(product);
		return product;
	}

	@Override
	public List<Product> getProductByCategory(Long categoryId) {
		return null;
	}

}
