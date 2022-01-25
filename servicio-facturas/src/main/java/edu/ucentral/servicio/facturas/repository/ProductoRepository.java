package edu.ucentral.servicio.facturas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.ucentral.servicio.facturas.model.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
	
	//manual
	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto> findByNombre(String term);
	
	
	public List<Producto> findByNombreContainingIgnoreCase(String term);
	
	
	public List<Producto> findByNombreStartingWithIgnoreCase(String term);
		
	

}
