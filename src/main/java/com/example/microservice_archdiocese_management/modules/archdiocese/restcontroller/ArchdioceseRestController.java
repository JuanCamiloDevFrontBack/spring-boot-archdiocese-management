package com.example.microservice_archdiocese_management.modules.archdiocese.restcontroller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice_archdiocese_management.exception.CustomException;
import com.example.microservice_archdiocese_management.modules.archdiocese.dto.DTO;
import com.example.microservice_archdiocese_management.utils.interfaces.HomeI;

@RestController
@RequestMapping("/features")
/*
 * Si es muy pequeño el microservicio los permisos de CORS se pueden gestionar con
 * esta anotación. En este caso de deja comentado porque se manejan de forma
 * general.
 * 
 * @CrossOrigin(origins = {"*"})
 */
public class ArchdioceseRestController {

	@Autowired
	private HomeI homeService;

	@GetMapping
	public String endpointTest() {
		Integer randomDecimal = new Random().nextInt(11);
		if (randomDecimal == 1) {
			throw CustomException.msgNotFound("Error manejado de forma centralizada por Spring Boot.");
		}
		return "Endpoint de bievenida y prueba de funcionamiento de la API.";
	}

	@GetMapping("/list-parishes")
	public ResponseEntity<List<DTO.ParishedList>> listParished() {
		return new ResponseEntity<>(this.homeService.listAllParished(), HttpStatus.OK);
	}

	@GetMapping("/list-priests")
	public ResponseEntity<List<DTO.PriestsList>> listPriests() {
		return new ResponseEntity<>(this.homeService.listAllPriest(), HttpStatus.OK);
	}

	@PostMapping("/add-parishes")
	// @valid para más adelante.
	public ResponseEntity<DTO.SuccessResponse> addNewParish(@RequestBody Optional<DTO.AddParished> newParished) {
		return ResponseEntity.ok(this.homeService.addNewParish(newParished));
	}
	
	@PostMapping("/add-priest")
	// @valid para más adelante.
	public ResponseEntity<DTO.SuccessResponse> addNewPriest(@RequestBody Optional<DTO.AddPriests> newPriest) {
		return ResponseEntity.ok(this.homeService.addNewPriest(newPriest));
	}
	
	@DeleteMapping("/delete-parishes/{id}")
	public ResponseEntity<DTO.SuccessResponse> deleteParish(@PathVariable Optional<String> id) {
		return ResponseEntity.ok(this.homeService.removeParish(id));
	}
	
	@DeleteMapping("/delete-priest/{id}")
	public ResponseEntity<DTO.SuccessResponse> deletePriest(@PathVariable Optional<String> id) {
		return ResponseEntity.ok(this.homeService.removePriest(id));
	}

}
