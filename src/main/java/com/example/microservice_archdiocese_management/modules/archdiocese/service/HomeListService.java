package com.example.microservice_archdiocese_management.modules.archdiocese.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.microservice_archdiocese_management.exception.CustomException;
import com.example.microservice_archdiocese_management.modules.archdiocese.dao.HomeIDAO;
import com.example.microservice_archdiocese_management.modules.archdiocese.dao.PriestsIDAO;
import com.example.microservice_archdiocese_management.modules.archdiocese.dto.DTO;
import com.example.microservice_archdiocese_management.modules.archdiocese.dto.DTO.SuccessResponse;
import com.example.microservice_archdiocese_management.modules.archdiocese.entity.ParishEntity;
import com.example.microservice_archdiocese_management.utils.interfaces.HomeI;

@Service
public class HomeListService implements HomeI {

	@Autowired
	private HomeIDAO homedb;

	@Autowired
	private PriestsIDAO priestdb;

	@Override
	public List<DTO.ParishedList> listAllParished() {
		allRegisI.clear();
		var allRegistersDb = this.homedb.findAll();

		// allRegistersDb.forEach(System.out::println);
		if (allRegistersDb.isEmpty()) {
			throw CustomException.msgNotFound("No existen parroquias en la base de datos.");
		}

		allRegistersDb.forEach(register -> {
			// allRegisI viene de la interfaz HomeI.
			allRegisI.add(DTO.parishedListInst(register.getName(), register.getAddress(), register.getLocation()));
		});

		return allRegisI;
	}

	@Override
	public List<DTO.PriestsList> listAllPriest() {
		var allRegistersDb = this.priestdb.findAll();
		var allRegisPriests = new ArrayList<DTO.PriestsList>();

		// allRegistersDb.forEach(System.out::println);
		if (allRegistersDb.isEmpty()) {
			throw CustomException.msgNotFound("No existen sacerdotes en la base de datos.");
		}

		allRegistersDb.forEach(register -> {
			var hasParish = register.getIsParishPriest().equals("S");
			allRegisPriests.add(DTO.priestsListInst(register.getName(), register.getAge(), register.getOrdinationDate(),
					hasParish));
		});

		return allRegisPriests;
	}

	@Override
	public SuccessResponse addNewParish(Optional<DTO.AddParished> newParished) {
		if (newParished.isEmpty()) {
			throw CustomException
					.msgErrorRequest("Error en la solicitud, no hay información presente en el cuerpo de la petición.");
		}

		/*
		 * try {
		 * 
		 * } catch (Exception e) { throw CustomException.msgErrorRequest(e); }
		 */

		var value = newParished.orElseThrow(
				() -> CustomException.msgErrorRequest(
				"Error en la solicitud, las propiedades del objecto presente en"
				+ "la petición no deben ser nullos."));
		 
		 var addRegis = ParishEntity.builder()
				 .name(value.name())
				 .address(value.address())
				 .location(value.district())
				 .build();
		 
		this.homedb.save(addRegis);

		return DTO.successResInst(HttpStatus.OK, "Proceso Éxitoso.");
	}

	@Override
	public SuccessResponse addNewPriest(Optional<DTO.AddPriests> newPriest) {
		// TODO Auto-generated method stub
		return null;
	}

}
