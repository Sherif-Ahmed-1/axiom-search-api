package com.axiom.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
/**
 * 
 * @author sherif
 * custom exception for system violation exception
 */
@Data
public class SystemException extends RuntimeException {
	private String message;
	private HttpStatus httpStatus;
	private String errorCode;

	public SystemException(String message, HttpStatus httpStatus, String errorCode) {
		super(message);
		this.message = message;
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
	}

}
