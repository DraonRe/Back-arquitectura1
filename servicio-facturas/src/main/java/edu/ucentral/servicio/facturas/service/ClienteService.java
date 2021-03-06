package edu.ucentral.servicio.facturas.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.ucentral.servicio.facturas.model.Cliente;
import edu.ucentral.servicio.facturas.model.Factura;
import edu.ucentral.servicio.facturas.model.Producto;
import edu.ucentral.servicio.facturas.model.Region;

public interface ClienteService {
	
	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
	
	public List<Region> findAllRegiones();
	
	public Factura findFacturaById(Long id);
	
	public Factura saveFactura(Factura factura);
	
	public void deleteFacturaById(Long id);
	
	public List<Cliente> findReferidosByVendedores(Long id);
	
	public List<Producto> findProductoByNombre(String term);


}
