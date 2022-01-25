package edu.ucentral.productos.controller;

import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.ucentral.common.productos.model.Producto;
import edu.ucentral.common.services.controller.CommonController;
import edu.ucentral.productos.service.ProductoService;

//capa controladora
//comunica con el front
@RestController

public class ProductoController extends CommonController<Producto,ProductoService> {

	
	//se deja solo modificar porque el resto esta en el common
	//editar
	//para editar PUT
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Producto producto,BindingResult result,@PathVariable Long id){
		
		//verifican errores
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		//Se hace casting
		Optional<Producto> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Producto prod = optional.get();
		prod.setCodigo(producto.getCodigo());
		prod.setNombre(producto.getNombre());
		prod.setPrecio(producto.getPrecio());
		prod.setCategoria(producto.getCategoria());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(prod));
	}
	
	//--------------Seccion agregar imagen----------------------
	
		//agregar parametro de la imagen
	
	@PostMapping("/crear-con-imagen")
	public ResponseEntity<?> crearConImagen(@Valid Producto producto,BindingResult result, @RequestParam MultipartFile archivo) throws IOException{
		
	
		if(!archivo.isEmpty()) {
			producto.setImagen(archivo.getBytes());
		}
		return super.crear(producto, result);
	}
	
	@PutMapping("/editar-con-imagen/{id}")
	public ResponseEntity<?> editarConImagen(@Valid Producto producto,BindingResult result,@PathVariable Long id, @RequestParam MultipartFile archivo) throws IOException{
		
		//verifican errores
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		//Se hace casting
		Optional<Producto> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Producto prod = optional.get();
		prod.setCodigo(producto.getCodigo());
		prod.setNombre(producto.getNombre());
		prod.setPrecio(producto.getPrecio());
		if(!archivo.isEmpty()) {
			prod.setImagen(archivo.getBytes());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(prod));
	}
	
	//metodo para traer la imagen	
	//consulta
	
	@GetMapping("/uploads/img/{id}")
	public ResponseEntity<?> verImagen(@PathVariable Long id){
		Optional<Producto> optional = service.findById(id);
		if(!optional.isPresent() || optional.get().getImagen()==null) {
			return ResponseEntity.notFound().build();
		}
		
		Resource img = new ByteArrayResource(optional.get().getImagen());
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img);
	}
}
