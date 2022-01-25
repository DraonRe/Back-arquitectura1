package edu.ucentral.servicio.facturas.repository;

import org.springframework.data.repository.CrudRepository;

import edu.ucentral.servicio.facturas.model.Factura;

public interface FacturaRepository extends CrudRepository<Factura, Long> {

}
