package edu.ucentral.productos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.ucentral.common.productos.model.Categoria;
import edu.ucentral.common.productos.model.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	@Query("from Categoria")
	public List<Categoria> findAllCategorias();

}
