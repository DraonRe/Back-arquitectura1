package edu.ucentral.common.services.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


//esta interfaz recibe como parametro una entidad

public interface CommonService<E> {
	
	//Capa de servicio
	
	//metodos basicos
	
	public Iterable<E> findAll();
	public Optional<E> findById(Long id);
	public E save(E entity);
	public void deleteById(Long id);
	
	//metodo nuevo paginacion
	public Page<E> findAll(Pageable pageable);
}
