package edu.ucentral.common.services.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import edu.ucentral.common.services.service.CommonService;

//capa controladora
//comunica con el front

//@RestController
//comunicacion con el front
@CrossOrigin(origins = {"http://localHost:4200"})
//se parametriza recibiendo una entity y una clase service
public class CommonController<E, S extends CommonService<E>> {

	@Autowired
	protected S service;
	
	
	//convertir la informacion a un JSON y retornar
	//el ? en por no saber que retorna
		
	//metodo de consulta GET
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	
	//metodo de consulta GET pero agregando las consultas por pagina
	@GetMapping("/pagina")
	public ResponseEntity<?> listar(Pageable pageable){
		return ResponseEntity.ok().body(service.findAll(pageable));
	}
	
	
	//diferente para buscar
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id){
		//Se hace casting
		Optional<E> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}
	
	//Crear
	//inserccion Post
	//BindingResult es para las validaciones
	@PostMapping
	public ResponseEntity<?> crear(@Valid @RequestBody E entity, BindingResult result){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		E entityBD = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityBD);
	}
	
	//eliminar
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	//se crea un mapa
	protected ResponseEntity<?> validar(BindingResult result){
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err ->{
			errores.put(err.getField(), "El atributo " + err.getField() + " " + err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}
	
}
