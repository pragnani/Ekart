package com.ekart.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.app.model.Category;
import com.ekart.app.model.Product;
import com.ekart.app.model.Role;
import com.ekart.app.model.User;

@Service
public class InitDbServiceImpl implements InitDbService {

	@Autowired
	UserService userService;
	
	@Autowired
	ProductService productService;

	@PostConstruct
	public void init() {

		try {

			List<Role> adminRolesList = new ArrayList<Role>();

			List<Role> userRoleList = new ArrayList<Role>();

			List<Role> merchantRoleList = new ArrayList<Role>();

			Role role_admin = new Role();
			role_admin.setName("ROLE_ADMIN");
			role_admin.setDisplayName("Admin");
			userService.createRole(role_admin);

			Role role_user = new Role();
			role_user.setName("ROLE_USER");
			role_user.setDisplayName("User");
			userService.createRole(role_user);

			Role role_merchant = new Role();
			role_merchant.setName("ROLE_MERCHANT");
			role_merchant.setDisplayName("Merchent");
			userService.createRole(role_merchant);

			adminRolesList.add(role_admin);
			adminRolesList.add(role_user);
			adminRolesList.add(role_merchant);

			userRoleList.add(role_user);

			merchantRoleList.add(role_merchant);

			User userAdmin = new User();
			userAdmin.setEmail("admin@ekart.com");
			userAdmin.setEnabled(true);
			userAdmin.setName("Pragnani Kinnera");
			userAdmin.setUsername("admin");
			userAdmin.setPassword("password");
			userAdmin.setRoles(adminRolesList);

			userService.createUser(userAdmin); 

			User userCustomer = new User();
			userCustomer.setEmail("nani@ekart.com");
			userCustomer.setEnabled(true);
			userCustomer.setName("Nani K");
			userCustomer.setUsername("nani");
			userCustomer.setPassword("password");
			userCustomer.setRoles(userRoleList);
			userService.createUser(userCustomer);

			User userMerchant = new User();
			userMerchant.setEmail("ramu@ekart.com");
			userMerchant.setEnabled(true);
			userMerchant.setName("Ramu P");
			userMerchant.setUsername("ramu");
			userMerchant.setPassword("password");
			userMerchant.setRoles(merchantRoleList);

			userService.createUser(userMerchant);
			
			Category category=new Category();
			category.setName("Testing");
			
			Product product = new Product();
			product.setProductName("Apple Iphone");
			product.setDiscount(100);
			product.setPrice(50000.00);
			
			productService.addProduct(product);
			
			List<Product> asList = Arrays.asList(new Product[]{ product});
			
			category.setProducts(new HashSet<>(asList));
			productService.addCategory(category);
			
			List<Category> allMainCategories = productService.getAllMainCategories();
			List<Category> allMainCategories2 = productService.getAllMainCategories();
			List<Category> allMainCategories3 = productService.getAllMainCategories();
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
