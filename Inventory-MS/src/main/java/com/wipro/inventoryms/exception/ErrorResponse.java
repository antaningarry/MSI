package com.wipro.inventoryms.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

	private LocalDateTime timestamp;

	private String errorMessage;

	private String status;

	private String path;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(LocalDateTime timestamp, String errorMessage, String status, String path) {
		super();
		this.timestamp = timestamp;
		this.errorMessage = errorMessage;
		this.status = status;
		this.path = path;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
