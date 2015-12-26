package com.ekart.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class HomeController implements IHomeController{

	@RequestMapping("/")
	String home() {
		return "home";
	}
}