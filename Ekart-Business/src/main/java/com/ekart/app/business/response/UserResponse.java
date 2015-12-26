package com.ekart.app.business.response;

import com.ekart.app.model.User;

public class UserResponse {

	Boolean status;
	User user;
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
