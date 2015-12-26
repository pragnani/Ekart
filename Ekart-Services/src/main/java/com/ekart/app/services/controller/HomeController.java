package com.ekart.app.services.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HomeController {

	@RequestMapping("/")
	String index() {
		return "Hello World";
	}
}