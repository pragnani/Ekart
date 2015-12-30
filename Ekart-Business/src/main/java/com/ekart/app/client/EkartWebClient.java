package com.ekart.app.client;

import static com.ekart.app.rest.DataServiceUtil.SERVER_ADDRESS;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import static com.ekart.app.rest.DataServiceUtil.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ekart.app.form.RegisterForm;
import com.ekart.app.model.User;

@Component
public class EkartWebClient {

	@Autowired
	HttpServletRequest request;

	public User registerUser(RegisterForm registerForm) {

		String url = SERVER_ADDRESS + POST_REGISTER_USER;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		RestTemplate template = new RestTemplate();
		User user = template.postForObject(url, registerForm, User.class);

		return user;
	}

	public User getUserByName(String name) {

		String url = SERVER_ADDRESS + GET_USER + "?name=" + name;
		RestTemplate template = new RestTemplate();

		User user = template.getForObject(url, User.class);

		return user;
	}

	public User getByCredentials(String base64CredString) {

		String url = SERVER_ADDRESS + POST_LOGIN;
		RestTemplate template = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64CredString);

		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<User> response = template.exchange(url, HttpMethod.POST, request, User.class);

		return response.getBody();
	}

}
