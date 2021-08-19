package com.br.FiltrosAndJasper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.FiltrosAndJasper.domain.Solucao;
import com.br.FiltrosAndJasper.repository.SolucaoRepository;

@Service
public class SolucaoService {

	@Autowired
	private SolucaoRepository repository;

	@Transactional(readOnly = true)
	public List<Solucao> buscarTodasSolucoes() {
		return repository.findAll();
	}
}
