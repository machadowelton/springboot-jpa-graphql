package br.com.machadowelton.services;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface IGenericService<T, ID> {
	
	public T buscarPorId(ID id);
	
	public List<T> listarPaginado(Pageable pageable);
	
	public T inserir(T t);
	
	public T atualizar(T t);
	
	public void deletarPorId(ID id);

}
