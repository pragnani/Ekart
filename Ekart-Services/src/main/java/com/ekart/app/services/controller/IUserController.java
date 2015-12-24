package com.ekart.app.services.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ekart.app.model.User;
import com.ekart.app.model.UserResponse;

public interface IUserController {

	public ResponseEntity<UserResponse> createUser(@RequestBody User user);

	public ResponseEntity<UserResponse> getUser(@PathVariable Long userId);
}
