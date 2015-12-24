package com.ekart.app.data.exception;

public class UserAlreadyExistException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4154549244018261024L;

	public UserAlreadyExistException(Throwable cause) {
		super(cause);
	}

	public UserAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAlreadyExistException(String message) {
		super(message);
	}

	public UserAlreadyExistException() {
	}
}
