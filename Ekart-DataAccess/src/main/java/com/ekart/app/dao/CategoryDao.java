package com.ekart.app.dao;

import java.util.List;

import com.ekart.app.model.Category;

public interface CategoryDao extends Dao<Category>{

    List<Category> findAllMainCategories();
}
