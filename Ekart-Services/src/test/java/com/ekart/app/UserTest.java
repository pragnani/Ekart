package com.ekart.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ekart.app.dao.UserDao;
import com.ekart.app.model.User;
import com.ekart.app.services.EkartApp;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes={EkartApp.class})
public class UserTest {
	
	@Autowired
	UserDao userDao;
	

	@Test
	public void testUser() throws Exception{
		User user = userDao.get(1L);
		System.out.println(user.getEmail());
	}
}
	