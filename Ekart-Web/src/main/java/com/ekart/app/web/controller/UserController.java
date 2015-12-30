package com.ekart.app.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ekart.app.business.response.Status;
import com.ekart.app.business.response.StatusFactory;
import com.ekart.app.client.EkartWebClient;
import com.ekart.app.form.LoginForm;
import com.ekart.app.form.RegisterForm;
import com.ekart.app.model.User;

@Controller
public class UserController implements IUserController {

	@Autowired
	EkartWebClient client;

	@Autowired
	@Qualifier("authenticationManager")
	AuthenticationManager authenticationManager;

	@RequestMapping("/register/available")
	@ResponseBody
	public String checkIfUserExists(@RequestParam String username) {
		System.out.println("Hello");
		User user = client.getUserByName(username);
		Boolean isExist = user == null;
		return isExist.toString();
	}

	

	@RequestMapping(path="/login", method = RequestMethod.POST)
	@ResponseBody
	public Status performLogin(@ModelAttribute LoginForm loginForm, HttpServletRequest request, HttpServletResponse response) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword());
		try {
			Authentication auth = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(auth);
			return StatusFactory.createSuccessStatus("Login Success");
		} catch (BadCredentialsException ex) {
			return StatusFactory.createFailureStatus("Bad Credentials");
		}
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Status registerUser(@ModelAttribute RegisterForm registrationForm) {
		try {

			User user = client.registerUser(registrationForm);
			Boolean success = (user != null);
			return success ? StatusFactory.createSuccessStatus("User Registration Successful") : StatusFactory.createFailureStatus("User Registration Failed");
		} catch (Exception e) {
			return StatusFactory.createFailureStatus("Something went wrong");
		}
	}



}
