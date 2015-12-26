package com.ekart.app.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ekart.app.client.EkartWebClient;
import com.ekart.app.form.RegisterForm;
import com.ekart.app.model.User;

@Controller
public class UserController implements IUserController {
	
	@Autowired
	EkartWebClient client; 

	@RequestMapping("/register/available")
	@ResponseBody
	public String checkIfUserExists(@RequestParam String username) {
		System.out.println("Hello");
		User user = client.getUserByName(username);
		Boolean isExist= user==null;
		return isExist.toString();
	}
	
	@RequestMapping(path="/register", method= RequestMethod.POST)
	@ResponseBody
	public RegisterForm registerUser(@ModelAttribute RegisterForm registrationForm){
		try {
		
		User user = client.registerUser(registrationForm);
		} catch (Exception e) {
			
		}
		return registrationForm; 
	}

}
