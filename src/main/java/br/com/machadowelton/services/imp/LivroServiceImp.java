package br.com.machadowelton.services.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.machadowelton.models.Livro;
import br.com.machadowelton.models.exception.NegocioException;
import br.com.machadowelton.services.ILivroService;
import br.com.machadowelton.services.abs.SuperAbs;
import br.com.machadowelton.services.repository.LivroRepository;
import br.com.machadowelton.services.repository.SessaoRepository;

@Component
public class LivroServiceImp extends SuperAbs<LivroRepository> implements ILivroService {

	@Autowired
	private SessaoRepository sessaoRepository;
	
	@Override
	public Livro buscarPorIdEIdSessao(Long id, Long idSessao) {
		return repository.findByIdAndSessaoId(id, idSessao)
				.map( livro -> {
					return livro;
				}).orElseThrow((() -> new NegocioException("Nenhum livro encontrado pelo id: " + id + " e idSessao: " + idSessao)));
	}

	@Override
	public List<Livro> listarPorIdSessaoPaginado(Long idSessao, Pageable pageable) {
		List<Livro> livros = repository.findBySessaoId(idSessao, pageable)
								.get()
								.collect(Collectors.toList());
		if(livros.size() < 1) 
			throw new NegocioException("Nenhum livro listado");
		return livros;
	}

	@Override
	public List<Livro> listarTodosPaginado(Pageable pageable) {
		List<Livro> livros = repository.findAll(pageable)
				.get()
				.collect(Collectors.toList());
		if(livros.size() < 1) 
			throw new NegocioException("Nenhum livro listado");
		return livros;
	}

	@Override
	public Livro inserir(Long idSessao, Livro livro) {
		return sessaoRepository.findById(idSessao)
				.map( sessao -> {
					livro.setSessao(sessao);
					return repository.save(livro);
				}).orElseThrow(() -> new NegocioException("Nenhuma sessão encontrada pelo id: " + idSessao));
	}

	@Override
	public Livro atualizar(Long idSessao, Livro livro) {
		if(!repository.existsByIdAndSessaoId(livro.getId(), idSessao))
			throw new NegocioException("Nenhum livro encontrado pelo id: " + livro.getId() + " e idSessao: " + idSessao);
		return repository.save(livro);
	}

	@Override
	public void deletarPorIdEIdSessao(Long id, Long idSessao) {
		if(!repository.existsByIdAndSessaoId(id, idSessao))
			throw new NegocioException("Nenhum livro encontrado pelo id: " +id + " e idSessao: " + idSessao);
		repository.deleteById(id);
	}

}
