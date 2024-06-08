package com.example.microservice_archdiocese_management.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DTOException implements Serializable {

	private static final long serialVersionUID = 1L;
	private HttpStatus status;
	private String message;	
	
}
