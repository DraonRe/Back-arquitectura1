package edu.ucentral.serviciousuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ucentral.commonusuarios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByUsername(String username);
}
