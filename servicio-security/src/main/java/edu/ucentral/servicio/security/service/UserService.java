package edu.ucentral.servicio.security.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import edu.ucentral.commonusuarios.model.Usuario;
import edu.ucentral.servicio.security.client.UsuarioFeignClient;

@Service
public class UserService implements UserDetailsService, IUsuarioServis{

	@Autowired
	private UsuarioFeignClient client;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = client.buscarPorUsername(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Error en el login, no existe usuario");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.collect(Collectors.toList());
		
		return new User(usuario.getUsername(),usuario.getPassword(), usuario.getEnabled(),true,true,true,authorities);
	}

	@Override
	public Usuario buscarPorUsername(String username) {
	
		return client.buscarPorUsername(username);
	}
	
	

}
