package com.ekart.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication(scanBasePackages = { "com.ekart.app" }, exclude = { ErrorMvcAutoConfiguration.class })
public class EkartWebApp {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;

	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EkartWebApp.class, args);
	}

}