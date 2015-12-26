package com.ekart.app.services.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6220512632157996937L;

	public NotFoundException() {
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
