package br.com.machadowelton.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

import br.com.machadowelton.models.Emprestimo;

public interface IEmprestimoService {
	
	public Emprestimo buscarPorIdEIdUsuario(Long id, Long IdUsuario);
	
	public List<Emprestimo> listarPorIdUsuarioPaginado(Long idUsuario, Pageable pageable);;
	
	public List<Emprestimo> listarTodosPaginado(Pageable pageable);
	
	public Emprestimo inserir(Long idUsuario, Emprestimo emprestimo);
	
	public Emprestimo atualizar(Long idUsuario, Emprestimo emprestimo);
	
	public void deletarPorIdEIdUsuario(Long id, Long idUsuario);
	
	public void addLivro(Long idUsuario, Long idEmprestimo, Long idLivro);
	
}
