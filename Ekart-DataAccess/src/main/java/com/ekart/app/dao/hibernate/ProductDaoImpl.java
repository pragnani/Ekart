package com.ekart.app.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.ekart.app.dao.ProductDao;
import com.ekart.app.model.Product;

@Repository
public class ProductDaoImpl extends AbstractHbnDao<Product> implements
		ProductDao {

}
