package com.example.microservice_archdiocese_management.modules.archdiocese.restcontroller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice_archdiocese_management.exception.CustomException;

@RestController
@RequestMapping("/features")
/*
 * Si es muy pequeño el microservicio los permisos de
 * CORS se pueden manejar con esta anotación.
 * En este caso de deja comentado porque se manejan de
 * forma general
 * @CrossOrigin(origins = {"*"})
 * */
public class ArchdioceseRestController {
	
	/*@Autowired
    private IRoleService roleService;*/

	@GetMapping
    public String endpointTest(){
        Integer randomDecimal = new Random().nextInt(11);
		if (randomDecimal == 1) {
			throw CustomException.msgNotFound("Erro manejado de forma centralizada por Spring Boot.");
		}
        return "Endpoint de bievenida y prueba de funcionamiento de la API.";
    }

	@PostMapping("/list-parishes")
    public ResponseEntity<?> listParished(){

         return new ResponseEntity<>(null, HttpStatus.OK);
    }
	
    /*@PostMapping("/list-parishes")
    public ResponseEntity<?> home(@RequestBody Usuario usuario){
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        Role role = roleService.buscarRolePorId(3);
        usuario.agregarRoleALista(role);
        usuario.setActivo(true);
        usuarioService.guardarUsuario(usuario);

        return ResponseEntity.ok("Usuario registrado correctamente");
    }*/
	
}
