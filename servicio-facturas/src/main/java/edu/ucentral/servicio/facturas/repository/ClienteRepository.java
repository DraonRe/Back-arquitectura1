package edu.ucentral.servicio.facturas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.ucentral.servicio.facturas.model.Cliente;
import edu.ucentral.servicio.facturas.model.Region;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query("from Region")
	public List<Region> findAllRegiones();
	
	
	@Query("select v from Cliente v  where v.id_Referido=?1")
	public List<Cliente> findReferidosByVendedores(Long id);

	
	
	
}
