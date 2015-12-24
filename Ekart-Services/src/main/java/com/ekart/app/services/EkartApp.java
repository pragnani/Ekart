package com.ekart.app.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;

@SpringBootApplication(scanBasePackages = { "com.ekart.app" }, exclude = { ErrorMvcAutoConfiguration.class })
public class EkartApp {

	

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EkartApp.class, args);
	}

}