package edu.ucentral.productos.service;




import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ucentral.common.productos.model.Categoria;
import edu.ucentral.common.productos.model.Producto;
import edu.ucentral.common.services.service.CommonServiceImpl;
import edu.ucentral.productos.repository.ProductoRepository;


//identifica que es un bean y que es una capa de servicio
//inyeccion de dependencias
@Service


//extiende del common
public class ProductoServiceImpl extends CommonServiceImpl<Producto, ProductoRepository> implements ProductoService {

	
	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findAllCategorias() {
		return repository.findAllCategorias();
		
	}

}
