package br.com.machadowelton.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import br.com.machadowelton.models.Livro;

public interface ILivroService {
	
	public Livro buscarPorIdEIdSessao(Long id, Long idSessao);
	
	public List<Livro> listarPorIdSessaoPaginado(Long idSessao, Pageable pageable);
	
	public List<Livro> listarTodosPaginado(Pageable pageable);
	
	public Livro inserir(Long idSessao, Livro livro);
	
	public Livro atualizar(Long idSessao, Livro livro);
	
	public void deletarPorIdEIdSessao(Long id, Long idSessao);
	
}
