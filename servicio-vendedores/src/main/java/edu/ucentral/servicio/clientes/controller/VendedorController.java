package edu.ucentral.servicio.clientes.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ucentral.common.services.controller.CommonController;
import edu.ucentral.common.vendedores.model.Vendedor;
import edu.ucentral.servicio.clientes.service.VendedorService;

@RestController
public class VendedorController extends CommonController<Vendedor, VendedorService> {
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Vendedor cliente,BindingResult result,@PathVariable Long id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Vendedor> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Vendedor client = optional.get();
		client.setNombre(cliente.getNombre());
		client.setNivel(cliente.getNivel());
		client.setDocumento(cliente.getDocumento());
		client.setDireccion(cliente.getDireccion());
		client.setCorreo(cliente.getCorreo());
		client.setTelefono(cliente.getTelefono());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(client));
	}

}
