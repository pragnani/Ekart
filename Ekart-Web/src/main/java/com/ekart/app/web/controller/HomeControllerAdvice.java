package com.ekart.app.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ekart.app.form.ILoginForm;
import com.ekart.app.form.IOffer;
import com.ekart.app.form.IRegisterForm;
import com.ekart.app.form.LoginForm;
import com.ekart.app.form.Offer;
import com.ekart.app.form.RegisterForm;

@ControllerAdvice(assignableTypes = { HomeController.class, UserController.class})
public class HomeControllerAdvice {

	@ModelAttribute("loginForm")
	public ILoginForm loginForm() {
		return new LoginForm();
	}

	@ModelAttribute("registerForm")
	public IRegisterForm registerForm() {
		return new RegisterForm();
	}
	
	@ModelAttribute("offerForm")
	public IOffer offer() {
		return new Offer();
	}

}
