package edu.ucentral.servicio.clientes.service;

import org.springframework.stereotype.Service;

import edu.ucentral.common.services.service.CommonServiceImpl;
import edu.ucentral.common.vendedores.model.Vendedor;
import edu.ucentral.servicio.clientes.repository.VendedorRepository;
@Service
public class VendedorServiceImpl extends CommonServiceImpl<Vendedor, VendedorRepository> implements VendedorService {

	
}
