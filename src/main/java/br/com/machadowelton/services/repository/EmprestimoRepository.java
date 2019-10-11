package br.com.machadowelton.services.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.machadowelton.models.Emprestimo;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
	
	public Optional<Emprestimo> findByIdAndUsuarioId(Long id, Long usuarioId);
	
	public Page<Emprestimo> findByUsuarioId(Long usuarioId, Pageable pageable);
	
	public boolean existsByIdAndUsuarioId(Long id, Long usuarioId);
	
}
