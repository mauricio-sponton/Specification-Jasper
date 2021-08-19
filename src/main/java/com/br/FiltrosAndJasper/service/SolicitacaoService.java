package com.br.FiltrosAndJasper.service;

import java.time.LocalDate;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.FiltrosAndJasper.datatables.Datatables;
import com.br.FiltrosAndJasper.datatables.DatatablesColunas;
import com.br.FiltrosAndJasper.domain.Solicitacao;
import com.br.FiltrosAndJasper.repository.SolicitacaoRepository;
import com.br.FiltrosAndJasper.specification.SpecificationSolicitacao;



@Service
public class SolicitacaoService {
	
	@Autowired
	private SolicitacaoRepository repository;
	
	@Autowired
	private Datatables datatables;

	@Transactional(readOnly = true)
	public Map<String, Object> buscarTodos(HttpServletRequest request, String buscaAssunto, String buscaCliente,
			String buscaUsuario, String buscaBairro, LocalDate buscaData, LocalDate buscaDataFinal, String status,
			String resultado, String aviso, String indicada) {
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.SOLICITACOES);
		Page<Solicitacao> page = null;
		Specification<Solicitacao> situacao = null;
		Specification<Solicitacao> resultado_solucao = null;
		Specification<Solicitacao> aviso_solucao = null;
		Specification<Solicitacao> data = null;
		Specification<Solicitacao> indicacao = null;

		if (datatables.getSearch().isEmpty()) {
			page = repository.findAll(datatables.getPageable());
		}
		if (!datatables.getSearch().isEmpty()) {
			page = repository.findByAssuntoOrUsuarioOrCliente(datatables.getSearch(), datatables.getPageable());
		}
		if (resultado != null) {
			if (resultado.equals("Positivo")) {
				resultado_solucao = SpecificationSolicitacao.resultadoPositivo(resultado);
			} else {
				resultado_solucao = SpecificationSolicitacao.resultadoNegativo(resultado);
			}

		}
		if (aviso != null) {
			if (aviso.equals("true")) {
				aviso_solucao = SpecificationSolicitacao.avisoTrue(aviso);
			} else {
				aviso_solucao = SpecificationSolicitacao.avisoFalse(aviso);
			}

		}
		if (indicada != null) {
			if (indicada.equals("true")) {
				indicacao = SpecificationSolicitacao.indicadaTrue(indicada);
			} else {
				indicacao = SpecificationSolicitacao.indicadaFalse(indicada);
			}

		}
		if (status != null) {
			switch (status) {
			case "finalizado":
				situacao = SpecificationSolicitacao.statusFinalizado(status);
				break;
			case "atrasado":
				situacao = SpecificationSolicitacao.statusAtrasado(status);
				break;
			case "pendente":
				situacao = SpecificationSolicitacao.statusPendente(status);
				break;
			case "aberto":
				situacao = SpecificationSolicitacao.statusAberto(status);
				break;

			}
		}
		if (buscaData != null) {
			data = SpecificationSolicitacao.dataIgual(buscaData);

		}
		if (buscaData != null && buscaDataFinal != null) {
			data = SpecificationSolicitacao.dataBetween(buscaData, buscaDataFinal);

		}

		if ((!buscaAssunto.isEmpty() || !buscaBairro.isEmpty() || !buscaCliente.isEmpty() || !buscaUsuario.isEmpty())
				|| buscaData != null || status != null || resultado != null || aviso != null || indicada != null) {
		
			page = repository.findAll(Specification.where(SpecificationSolicitacao.assunto(buscaAssunto))
					.and(SpecificationSolicitacao.nomeCliente(buscaCliente))
					.and(SpecificationSolicitacao.usuario(buscaUsuario))
					.and(SpecificationSolicitacao.bairro(buscaBairro)).and(situacao).and(data).and(resultado_solucao)
					.and(aviso_solucao).and(indicacao), datatables.getPageable());
		}

		return datatables.getResponse(page);
	}

	@Transactional(readOnly = true)
	public Solicitacao buscarPorId(Long id) {
		return repository.findById(id).get();
	}
}
