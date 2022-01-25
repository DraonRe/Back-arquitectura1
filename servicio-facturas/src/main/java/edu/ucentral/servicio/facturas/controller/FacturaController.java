package edu.ucentral.servicio.facturas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.ucentral.servicio.facturas.model.Factura;
import edu.ucentral.servicio.facturas.model.Producto;
import edu.ucentral.servicio.facturas.service.ClienteService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class FacturaController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/facturas/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Factura listar(@PathVariable Long id) {
		return clienteService.findFacturaById(id);
	}

	@DeleteMapping("/facturas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.deleteFacturaById(id);
	}

	@GetMapping("/facturas/filtrar-productos/{term}")
	@ResponseStatus(HttpStatus.OK)
	public List<Producto> filtrarProductos(@PathVariable String term){
		return clienteService.findProductoByNombre(term);
	}
	
	@PostMapping("/facturas")
	@ResponseStatus(HttpStatus.CREATED)
	public Factura crear(@RequestBody Factura factura) {
		return clienteService.saveFactura(factura);
	}
}
