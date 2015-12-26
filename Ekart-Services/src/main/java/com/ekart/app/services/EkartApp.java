package com.ekart.app.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@SpringBootApplication(scanBasePackages = { "com.ekart.app" }, exclude = { ErrorMvcAutoConfiguration.class })
public class EkartApp {

	@Bean
	public Jackson2ObjectMapperBuilder configureObjectMapper() {
		return new Jackson2ObjectMapperBuilder()
				.modulesToInstall(Hibernate4Module.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EkartApp.class, args);
	}

}