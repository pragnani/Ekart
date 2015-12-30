package com.ekart.app.services.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.app.data.exception.UserAlreadyExistException;
import com.ekart.app.model.Role;
import com.ekart.app.model.User;
import com.ekart.app.model.UserResponse;
import com.ekart.app.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController implements IUserController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserResponse> createUser(@RequestBody User user) {

		UserResponse userReponse = new UserResponse();
		try {
			userService.createUser(user);
			userReponse.setUser(user);
			userReponse.setStatus(true);
		} catch (UserAlreadyExistException e) {
			return new ResponseEntity<UserResponse>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<UserResponse>(userReponse, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<UserResponse> getUser(@PathVariable Long userId) {

		UserResponse userReponse = new UserResponse();
		try {
			User user = userService.getUser(userId);
			userReponse.setUser(user);
			userReponse.setStatus(true);
		} catch (Exception e) {
			return new ResponseEntity<UserResponse>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserResponse>(userReponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public ResponseEntity<List<Role>> getUserRoles() {
		List<Role> rolesList;
		try {
			rolesList = userService.getAllRoles();
		} catch (Exception e) {
			return new ResponseEntity<List<Role>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Role>>(rolesList, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@RequestParam String name) {
		User user;
		try {
			user = (User) userService.getByName(name);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> loginUser(@RequestHeader("Authorization") String authorization) {
		User user = null;
		try {
			if (authorization != null && authorization.startsWith("Basic")) {
				// Authorization: Basic base64credentials
				String base64Credentials = authorization.substring("Basic".length()).trim();
				String credentials = new String(Base64.decodeBase64(base64Credentials), Charset.forName("UTF-8"));
				// credentials = username:password
				final String[] values = credentials.split(":", 2);

				user = (User) userService.getByUserNameAndPassword(values[0], values[1]);
			}
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
