package com.ekart.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.app.model.Role;
import com.ekart.app.model.User;

@Service
public class InitDbServiceImpl implements InitDbService {

	@Autowired
	UserService userService;
	

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
			userAdmin.setName("admin");
			userAdmin.setPassword("password");
			userAdmin.setRoles(adminRolesList);

			userService.createUser(userAdmin); 

			User userCustomer = new User();
			userCustomer.setEmail("nani@ekart.com");
			userCustomer.setEnabled(true);
			userCustomer.setName("nani");
			userCustomer.setPassword("password");
			userCustomer.setRoles(userRoleList);
			userService.createUser(userCustomer);

			User userMerchant = new User();
			userMerchant.setEmail("ramu@ekart.com");
			userMerchant.setEnabled(true);
			userMerchant.setName("ramu");
			userMerchant.setPassword("password");
			userMerchant.setRoles(merchantRoleList);

			userService.createUser(userMerchant);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
