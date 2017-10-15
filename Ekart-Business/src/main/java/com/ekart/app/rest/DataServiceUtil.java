package com.ekart.app.rest;

import org.springframework.beans.factory.annotation.Value;

public final class DataServiceUtil {

	@Value("${server.address}")
	public static final String SERVER_ADDRESS = "http://localhost:9090";

	public static final String POST_REGISTER_USER = "/user";
	
	public static final String GET_USER = "/user";

	public static final String POST_LOGIN = "/user/login";

	public static final String GET_ROLES = "/user/roles";

}
