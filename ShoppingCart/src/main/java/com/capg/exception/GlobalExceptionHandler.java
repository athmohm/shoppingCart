package com.capg.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleRecordNotFoundExeption(ResourceNotFoundException ex, WebRequest request) {
		// creating exception response structure

		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(LoginException.class)
	public @ResponseBody ErrorDetails loginExceptionHandler(LoginException n, HttpServletRequest req) {
		ErrorDetails er = new ErrorDetails(new Date(), n.getMessage(), req.getRequestURI());
		return er;
	}

	@ExceptionHandler(NotFoundException.class)
	public @ResponseBody ErrorDetails userNotFoundExceptionHandler(NotFoundException n, HttpServletRequest req) {
		ErrorDetails er = new ErrorDetails(new Date(), n.getMessage(), req.getRequestURI());
		return er;
	}
	
	

}