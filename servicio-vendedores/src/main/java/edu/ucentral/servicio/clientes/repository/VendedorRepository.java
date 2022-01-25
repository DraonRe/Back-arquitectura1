package edu.ucentral.servicio.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ucentral.common.vendedores.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

}
