package com.ekart.app.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.ekart.app.dao.CategoryDao;
import com.ekart.app.model.Category;

@Repository
public class CategoryDaoImpl extends AbstractHbnDao<Category> implements CategoryDao {

	@Cacheable(key="category.id")
	@Override
	public List<Category> findAllMainCategories() {
		  Query query = getSession().getNamedQuery("findMainCategories"); 
		  System.out.println(getSession().getSessionFactory().getStatistics().getSecondLevelCacheHitCount());
		return query.list();
	}

}
