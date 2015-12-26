package com.ekart.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ekart.app.model.User;
import com.ekart.app.service.UserService;
import com.ekart.app.services.EkartApp;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes={EkartApp.class})
public class UserTest {
	
	@Autowired
	UserService userService;
	

	@Test
	public void testUser() throws Exception{
		User user = userService.getUser(1L);
		System.out.println(user.getEmail());
	}
}
	