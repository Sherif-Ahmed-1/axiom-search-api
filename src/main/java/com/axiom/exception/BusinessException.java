package com.axiom.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

/**
 * 
 * @author sherif
 * custom exception for is business rule violation
 */
@Data
public class BusinessException extends RuntimeException {

	private String message;
	private HttpStatus httpStatus;
	private String errorCode;

	public BusinessException(String message, HttpStatus httpStatus, String errorCode) {
		super(message);
		this.message = message;
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
	}

}
