package br.com.machadowelton.services.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.machadowelton.models.Usuario;
import br.com.machadowelton.models.exception.NegocioException;
import br.com.machadowelton.services.IUsuarioService;
import br.com.machadowelton.services.abs.SuperAbs;
import br.com.machadowelton.services.repository.UsuarioRepository;


@Service
public class UsuarioServiceImp extends SuperAbs<UsuarioRepository> implements IUsuarioService {

	@Override
	public Usuario buscarPorId(Long id) {
		logger.info("metodo=buscarPorId, id=" + id);
		return repository.findById(id)
				.map( u -> {
					logger.info("metodo=buscarPorId, usuario=" + u);
					return u;
				}).orElseThrow(() -> new NegocioException("Nenhum usuário encontrado com o id: " + id));
	}

	@Override
	public List<Usuario> listarPaginado(Pageable pageable) {
		logger.info("metodo=listarPaginado");
		List<Usuario> usuarios = repository.findAll(pageable)
									.get()
									.collect(Collectors.toList());
		if(usuarios.size() < 1)
			throw new NegocioException("Nenhum usuário encontrado");
		logger.info("metodo=listarPaginado, usuarios=" + usuarios);
		return usuarios;
	}

	@Override
	public Usuario inserir(Usuario t) {
		logger.info("metodo=inserir, usuario=" + t);
		return repository.save(t);
	}

	@Override
	public Usuario atualizar(Usuario t) {
		logger.info("metodo=atualizar, usuario=" + t);
		if(!repository.existsById(t.getId()))
			throw new NegocioException("Nenhum usuário encontrado pelo id: " + t.getId());
		return repository.save(t);
	}

	@Override
	public void deletarPorId(Long id) {
		logger.info("metodo=deletarPorId, id=" + id);
		if(!repository.existsById(id))
			throw new NegocioException("Nenhum usuário encontrado pelo id: " + id);
		repository.deleteById(id);
	}

}
