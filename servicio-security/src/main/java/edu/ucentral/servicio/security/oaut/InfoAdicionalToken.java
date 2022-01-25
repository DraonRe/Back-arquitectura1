package edu.ucentral.servicio.security.oaut;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import edu.ucentral.commonusuarios.model.Usuario;

import edu.ucentral.servicio.security.service.IUsuarioServis;
@Component
public class InfoAdicionalToken implements TokenEnhancer {

	@Autowired
	private  IUsuarioServis usuarioService;
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Usuario usuario = usuarioService.buscarPorUsername(authentication.getName());
		Map<String, Object> info= new HashMap<>();
		info.put("id", usuario.getId());
		info.put("nombre", usuario.getNombre());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
