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
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.context.SecurityContextRepository;
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

	@Autowired
	@Qualifier("authenticationManager")
	AuthenticationManager authenticationManager;

	@Autowired
	SecurityContextRepository repository;

	@Autowired
	RememberMeServices rememberMeServices;

	@RequestMapping("/register/available")
	@ResponseBody
	public String checkIfUserExists(@RequestParam String username) {
		System.out.println("Hello");
		User user = client.getUserByName(username);
		Boolean isExist = user == null;
		return isExist.toString();
	}

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public void login() {
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String performLogin(@RequestParam("j_username") String username,
			@RequestParam("j_password") String password,
			HttpServletRequest request, HttpServletResponse response) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				username, password);
		try {
			Authentication auth = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(auth);
			repository.saveContext(SecurityContextHolder.getContext(), request,
					response);
			rememberMeServices.loginSuccess(request, response, auth);
			return "{\"status\": true}";
		} catch (BadCredentialsException ex) {
			return "{\"status\": false, \"error\": \"Bad Credentials\"}";
		}
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	@ResponseBody
	public RegisterForm registerUser(
			@ModelAttribute RegisterForm registrationForm) {
		try {

			User user = client.registerUser(registrationForm);
		} catch (Exception e) {

		}
		return registrationForm;
	}

}
