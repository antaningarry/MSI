package com.wipro.inventoryms.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ResourceNotFoundException.class })
	public ResponseEntity<ErrorResponse> handleException(ResourceNotFoundException ex, HttpServletRequest request) {
		ErrorResponse response = new ErrorResponse(LocalDateTime.now(), ex.getMessage(),
				HttpStatus.NOT_FOUND.toString(), request.getRequestURI().toString());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
