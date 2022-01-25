package edu.ucentral.servicio.facturas.controller;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.AbstractResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import edu.ucentral.servicio.facturas.model.Cliente;
import edu.ucentral.servicio.facturas.model.Region;
import edu.ucentral.servicio.facturas.service.ClienteService;



@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	private final Logger log = org.slf4j.LoggerFactory.getLogger(ClienteController.class);
	
	
	//listar
	@GetMapping("/clientes")
	public List<Cliente> listar(){
		return clienteService.findAll();
	}
	
	
	
	//paginar
	@GetMapping("/clientes/page/{page}")
	public Page<Cliente> listar(@PathVariable Integer page){
		Pageable pageable=PageRequest.of(page, 4);
		return clienteService.findAll(pageable);
	}
	
	//buscar por id
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		
		Cliente cliente = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			cliente=clienteService.findById(id);
		} catch (DataAccessException e) {
			
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String , Object>>(response, HttpStatus.NOT_FOUND);
			
		}
		
		
		if(cliente == null) {
			response.put("mensaje", "El vendedor ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String , Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
	}
	
	//crear
	@PostMapping("/clientes")
	public ResponseEntity<?> crear(@RequestBody Cliente cliente) {
		
		Cliente clienteNew=null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			clienteNew= clienteService.save(cliente);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String , Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("mensaje", "El vendedor se ha creado con exito!");
		response.put("cliente", clienteNew);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
	}
	
	//modificar
	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> modificar(@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente clienteBd = clienteService.findById(id);
		
		Cliente clienteModificado=null;
		Map<String, Object> response = new HashMap<>();

		if(clienteBd == null) {
			response.put("mensaje", "Error, no se pudo editar,El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String , Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			clienteBd.setApellido(cliente.getApellido());
			clienteBd.setNombre(cliente.getNombre());
			clienteBd.setNivel(cliente.getNivel());
			clienteBd.setDireccion(cliente.getDocumento());
			clienteBd.setTelefono(cliente.getTelefono());
			clienteBd.setEmail(cliente.getEmail());
			clienteBd.setCreateAt(cliente.getCreateAt());
			clienteBd.setRegion(cliente.getRegion());
			
			clienteModificado= clienteService.save(clienteBd);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String , Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cliente se ha modificado con exito!");
		response.put("cliente", clienteModificado);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);

		
	}
	
	//eliminar
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			
			Cliente cliente=clienteService.findById(id);
			String nombreFotoAnterior = cliente.getFoto();
			
			if(nombreFotoAnterior !=null && nombreFotoAnterior.length()>0) {
				Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
				File archivoFotoAnterior = rutaFotoAnterior.toFile();
				if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
					archivoFotoAnterior.delete();
				}
			}
			
			
			clienteService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminal al cliente en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String , Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente eliminado con exito!");
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
	}
	
	
	//listar
	@GetMapping("/clientes/regiones")
	public List<Region> listarRegiones(){
		return clienteService.findAllRegiones();
	}
	
	@PostMapping("/clientes/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id){
		
		Map<String, Object> response = new HashMap<>();
		
		Cliente cliente=clienteService.findById(id);
		
		if(!archivo.isEmpty()) {
			String nombreArchivo = UUID.randomUUID().toString() + "_"+ archivo.getOriginalFilename().replace(" ", " ");
			
			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
			log.info(rutaArchivo.toString());
			
			
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen base de datos"+ nombreArchivo);
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String , Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

				
			}
			
			String nombreFotoAnterior = cliente.getFoto();
			
			if(nombreFotoAnterior !=null && nombreFotoAnterior.length()>0) {
				Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
				File archivoFotoAnterior = rutaFotoAnterior.toFile();
				if(archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
					archivoFotoAnterior.delete();
				}
			}
			
			cliente.setFoto(nombreArchivo);
			
			clienteService.save(cliente);
			
			response.put("cliente", cliente);
			response.put("mensaje", "Has subido correctame la imagen" + nombreArchivo);
			
		}
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);

	}
	
	@GetMapping("/uploads/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){
		
		Path rutaArchivo = Paths.get("uploads").resolve(nombreFoto).toAbsolutePath();
		log.info(rutaArchivo.toString());

		Resource recurso = null;
		
		try {
			recurso = (Resource) new UrlResource(rutaArchivo.toUri());
		}catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		if(!recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("Error no se pudo cargar la imagen: " + nombreFoto);
		}
		
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+ ((AbstractResource) recurso).getFilename()+"\"");
		
		
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/referidos/{id}")
	public ResponseEntity<?> buscarPorIdReferido(@PathVariable Long id){
		//Se hace casting
		List<Cliente> lista = clienteService.findReferidosByVendedores(id);
		
		return ResponseEntity.ok(lista);
	
}
	
	

}
