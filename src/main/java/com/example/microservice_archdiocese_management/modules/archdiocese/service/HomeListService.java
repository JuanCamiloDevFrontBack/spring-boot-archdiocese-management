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
import com.example.microservice_archdiocese_management.modules.archdiocese.entity.PriestsEntity;
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
			var idToString = register.getId().toString();
			allRegisI.add(DTO.parishedListInst(idToString, register.getName(), register.getAddress(), register.getLocation()));
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
			var idToString = register.getId().toString();
			var hasParish = register.getIsParishPriest().equals("S");
			allRegisPriests.add(DTO.priestsListInst(idToString, register.getName(), register.getAge(), register.getOrdinationDate(),
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
		 * Esta opción hace lo mismo que el if anterior, aplicaría si no existiera el
		 * Optional.
		 * 
		 * var value = newParished.orElseThrow( () -> CustomException.msgErrorRequest(
		 * "Error en la solicitud, las propiedades del objecto presente en" +
		 * "la petición no deben ser nullos con orElsThrow."));
		 */

		var addRegis = ParishEntity.builder()
				.name(newParished.get().name())
				.address(newParished.get().address())
				.location(newParished.get().district())
				.build();

		this.homedb.save(addRegis);

		return DTO.successResInst(HttpStatus.OK, "Se registro la parroquia correctamente.");
	}

	@Override
	public SuccessResponse addNewPriest(Optional<DTO.AddPriests> newPriest) {
		if (newPriest.isEmpty()) {
			throw CustomException
					.msgErrorRequest("Error en la solicitud, no hay información presente en el cuerpo de la petición.");
		}
		
		var hasParish = newPriest.get().isParishPriest() ? "S": "N";
		var convertToInt = Integer.valueOf(newPriest.get().idParish());

		var addRegis = PriestsEntity.builder()
				.name(newPriest.get().name())
				.age(newPriest.get().age())
				.ordinationDate(newPriest.get().ordinationDate())
				.isParishPriest(hasParish)
				.idParish(convertToInt)
				.build();

		this.priestdb.save(addRegis);

		return DTO.successResInst(HttpStatus.OK, "Se registro el sacerdote correctamente.");
	}

	@Override
	public SuccessResponse removeParish(Optional<String> id) {
		if (id.isEmpty()) {
			throw CustomException
					.msgErrorRequest("Error en la solicitud, no se recibió el id del registro.");
		}
		
		this.homedb.deleteById(Integer.valueOf(id.get()));
		
		return DTO.successResInst(HttpStatus.OK, "Se eliminó el registro correctamente.");
	}

	@Override
	public SuccessResponse removePriest(Optional<String> id) {
		if (id.isEmpty()) {
			throw CustomException
					.msgErrorRequest("Error en la solicitud, no se recibió el id del registro.");
		}
		
		this.priestdb.deleteById(Integer.valueOf(id.get()));
		
		return DTO.successResInst(HttpStatus.OK, "Se eliminó el registro correctamente.");
	}

}
