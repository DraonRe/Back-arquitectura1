package edu.ucentral.common.services.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


//identifica que es un bean y que es una capa de servicio
//inyeccion de dependencias
//se quita la notacion de service
//@Service
//se deja generica y recibe dos parametors entity y 
//una clase de tipo repositorio

public class CommonServiceImpl<E,R extends JpaRepository<E,Long>> implements CommonService<E> {

	
	//llamar al repository
	@Autowired
	protected R repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<E> findAll() {
		return repository.findAll();
	}
	
	//metodo de paginacion del service
	@Override
	@Transactional(readOnly = true)
	public Page<E> findAll(Pageable pageable){
		return repository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<E> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public E save(E entity) {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
