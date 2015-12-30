package com.ekart.app.business.response;

public class StatusFactory {
	public static Status createSuccessStatus(String message) {
		Status status = createStatus(true);
		status.setStatus(message);
		return status;
	}

	public static Status createFailureStatus(String message) {
		Status status = createStatus(false);
		status.setStatus(message);
		return status;
	}

	private static Status createStatus(Boolean success) {
		Status status = new Status();
		status.setSuccess(success);
		return status;
	}

}
