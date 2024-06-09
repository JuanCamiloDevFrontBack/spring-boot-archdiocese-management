package com.example.microservice_archdiocese_management.modules.archdiocese.entity;

import java.time.LocalDate;
import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "priest")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriestsEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private Integer age;

	@Column(name = "ordination_date")
	private LocalDate ordinationDate;
	
	@Column(name = "is_parish_priest")
	private String isParishPriest;
	
	@Column(name = "id_parish", nullable = true)
	private Integer idParish;
	
}
