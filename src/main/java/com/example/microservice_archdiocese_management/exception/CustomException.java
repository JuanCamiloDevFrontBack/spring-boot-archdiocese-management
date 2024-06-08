package com.example.microservice_archdiocese_management.exception;

/* Creo esta OuterClass para evitar tener demasiados archivos
 * y así encontrar una clase DTO de excepciones más facilmente. */
public class CustomException {

	// Metodos:
	public static CustomException.RecordsNotFound msgNotFound(String msg) {
		return new RecordsNotFound(msg);
	}
	
	public static CustomException.NotContentRequest msgErrorRequest(String msg) {
		return new NotContentRequest(msg);
	}


	/* Clases Manejadoras de Excepciones Presonalizadas :) */
	public static class RecordsNotFound extends RuntimeException {

		private String message;

		public RecordsNotFound(String message) {
			super(message);
			this.message = message;
		}

		public String getMessage() {
			return this.message;
		}
	}
	
	public static class NotContentRequest extends RuntimeException {

		private String message;

		public NotContentRequest(String message) {
			super(message);
			this.message = message;
		}

		public String getMessage() {
			return this.message;
		}
	}
	
}
