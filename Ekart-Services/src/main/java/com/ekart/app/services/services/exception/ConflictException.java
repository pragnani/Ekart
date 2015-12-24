package com.ekart.app.services.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4260256767310089553L;

	public ConflictException() {
	}

	public ConflictException(Throwable cause) {
		super(cause);
	}
}
