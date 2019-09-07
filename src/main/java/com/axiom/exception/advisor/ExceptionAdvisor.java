package com.axiom.exception.advisor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.axiom.exception.BusinessException;
import com.axiom.exception.SystemException;
import com.axiom.exception.dto.ExceptionModel;

/**
 * 
 * @author sherif handle system exceptions and return custom response to client
 */
@ControllerAdvice
public class ExceptionAdvisor {

	@ExceptionHandler(BusinessException.class)
	private ResponseEntity<ExceptionModel> handleBusinessException(BusinessException exception, WebRequest request) {
		ExceptionModel model = ExceptionModel.builder().message(exception.getMessage())
				.errorCode(exception.getErrorCode()).build();
		if (exception.getHttpStatus() == null)
			return new ResponseEntity<ExceptionModel>(model, HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ExceptionModel>(model, exception.getHttpStatus());
	}

	@ExceptionHandler(SystemException.class)
	private ResponseEntity<ExceptionModel> handleSystemException(SystemException exception, WebRequest request) {
		ExceptionModel model = ExceptionModel.builder().message(exception.getMessage())
				.errorCode(exception.getErrorCode()).build();
		if (exception.getHttpStatus() == null)
			return new ResponseEntity<ExceptionModel>(model, HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<ExceptionModel>(model, exception.getHttpStatus());
	}

	@ExceptionHandler(Exception.class)
	private ResponseEntity<ExceptionModel> handleException(Exception exception, WebRequest request) {
		ExceptionModel model = ExceptionModel.builder().message(exception.getMessage()).build();
		return new ResponseEntity<ExceptionModel>(model, HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
