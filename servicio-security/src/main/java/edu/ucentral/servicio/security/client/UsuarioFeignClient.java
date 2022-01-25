package edu.ucentral.servicio.security.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import edu.ucentral.commonusuarios.model.Usuario;

@FeignClient("servicio-usuarios")
public interface UsuarioFeignClient {

	@GetMapping("/username/{username}")
	public Usuario buscarPorUsername(@PathVariable String username);
}
