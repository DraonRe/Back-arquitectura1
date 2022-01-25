package edu.ucentral.productos.service;

import java.util.List;

import edu.ucentral.common.productos.model.Categoria;
import edu.ucentral.common.productos.model.Producto;
import edu.ucentral.common.services.service.CommonService;

//extiende de commonservice
public interface ProductoService extends CommonService<Producto> {
	
	public List<Categoria> findAllCategorias();
	
}
