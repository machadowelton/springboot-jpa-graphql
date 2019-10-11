package br.com.machadowelton.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import br.com.machadowelton.models.Usuario;
import br.com.machadowelton.services.imp.UsuarioServiceImp;

@Component
public class UsuarioResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
	
	
	@Autowired
	private UsuarioServiceImp service;
	
	public Usuario buscarUsuarioPorId(Long id) {
		return service.buscarPorId(id);
	}
	
	public Usuario inserirUsuario(Usuario usuario) {
		return service.inserir(usuario);
	}
	
}
