package com.example.microservice_archdiocese_management.modules.archdiocese.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.http.HttpStatus;
/*
 * Los records están disponibles desde la versión 14 de java,
 * si se utiliza la 11 se debe manejar con clases tradicionales.
 * */
public record DTO() {
	
	public static DTO.ParishedList parishedListInst(String id, String name, String address, String district) {
		return new ParishedList(1L, id, name, address, district);
	}
	
	public static DTO.PriestsList priestsListInst(String id, String name, Integer age, LocalDate ordinationDate, Boolean isParishPriest) {
		return new PriestsList(1L, id, name, age, ordinationDate, isParishPriest);
	}
	
	public static DTO.PriestsList parishedListInst(String id, String name, Integer age, LocalDate ordinationDate, Boolean isParishPriest) {
		return new PriestsList(1L, id, name, age, ordinationDate, isParishPriest);
	}
	
	public static DTO.SuccessResponse successResInst(HttpStatus codeRes, String msg) {
		return new SuccessResponse(1L, codeRes, msg);
	}

	public static record ParishedList(
			Long idSerial,
			String id,
			String name,
			String address,
			String district) implements Serializable {}
	
	public static record PriestsList(
			Long idSerial,
			String id,
			String name,
			Integer age,
			LocalDate ordinationDate,
			Boolean isParishPriest) implements Serializable {}
	
	public static record InfoParished(
			String id,
			String name,
			String address,
			String district) implements Serializable {}
	
	public static record InfoPriests(
			String id,
			String name,
			Integer age,
			LocalDate ordinationDate,
			Boolean isParishPriest,
			String idParish) implements Serializable {}
	
	public static record SuccessResponse(
			Long idSerial,
			HttpStatus status,
			String msg) implements Serializable {}
	
}
