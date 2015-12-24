package com.ekart.app.data.exception;

public class UserDoesNotExistException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4154549244018261024L;

	public UserDoesNotExistException(Throwable cause) {
		super(cause);
	}

	public UserDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserDoesNotExistException(String message) {
		super(message);
	}

	public UserDoesNotExistException() {
	}
}
