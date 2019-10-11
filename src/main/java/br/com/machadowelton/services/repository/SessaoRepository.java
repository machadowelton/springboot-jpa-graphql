package br.com.machadowelton.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.machadowelton.models.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long> {

}
