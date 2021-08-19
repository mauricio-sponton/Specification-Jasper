package com.br.FiltrosAndJasper.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.br.FiltrosAndJasper.domain.Solicitacao;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long>, JpaSpecificationExecutor<Solicitacao>{

	@Query("select s from Solicitacao s where s.assunto like :search% or s.municipe like :search% or s.usuario like :search%")
	Page<Solicitacao> findByAssuntoOrUsuarioOrCliente(String search, Pageable pageable);
}
