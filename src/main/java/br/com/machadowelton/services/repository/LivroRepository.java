package br.com.machadowelton.services.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.machadowelton.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
	
	public Optional<Livro> findByIdAndSessaoId(Long id, Long sessaoId);
	
	public Page<Livro> findBySessaoId(Long sessaoId, Pageable pageable);
	
	public boolean existsByIdAndSessaoId(Long id, Long sessaoId);
	
}
