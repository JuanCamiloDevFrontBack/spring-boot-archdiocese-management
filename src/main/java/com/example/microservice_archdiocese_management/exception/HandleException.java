package com.example.microservice_archdiocese_management.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestControllerAdvice
public class HandleException extends ResponseEntityExceptionHandler {

	@ExceptionHandler({CustomException.RecordsNotFound.class, SQLException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	protected ResponseEntity<DTOException> handleExceptionNotFound(CustomException.RecordsNotFound exception) {

		var notFoundError = DTOException.builder().message((String) exception.getMessage())
				.status(HttpStatus.NOT_FOUND).build();

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundError);

	}
	
	@ExceptionHandler(CustomException.NotContentRequest.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ResponseEntity<DTOException> handleExceptionNotContentRequest(CustomException.NotContentRequest exception) {

		var errorRequestClient = DTOException.builder().message((String) exception.getMessage())
				.status(HttpStatus.BAD_REQUEST).build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRequestClient);

	}

}
