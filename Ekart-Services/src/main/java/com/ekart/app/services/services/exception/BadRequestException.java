package com.ekart.app.services.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4750767278494438138L;

	public BadRequestException() {
	}

	public BadRequestException(Throwable cause) {
		super(cause);
	}
}
