package com.br.FiltrosAndJasper.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.FiltrosAndJasper.domain.Solicitacao;
import com.br.FiltrosAndJasper.service.JasperService;
import com.br.FiltrosAndJasper.service.SolicitacaoService;
import com.br.FiltrosAndJasper.service.SolucaoService;

@Controller
public class SolicitacaoController {
	
	@Autowired
	private SolicitacaoService service;
	
	@Autowired
	private SolucaoService solucaoService;
	
	@Autowired
	private JasperService jasperService;

	@GetMapping({"/", "home"})
	public String listarRelatorios(ModelMap model) {
		model.addAttribute("solucoes", solucaoService.buscarTodasSolucoes());
		return "index";
	}
	
	@GetMapping("/datatables/server")
	public ResponseEntity<?> listarSolicitacoesDatatables(HttpServletRequest request,
			@RequestParam(required = false, value = "buscaAssunto") String buscaAssunto,
			@RequestParam(required = false, value = "buscaCliente") String buscaCliente,
			@RequestParam(required = false, value = "buscaUsuario") String buscaUsuario,
			@RequestParam(required = false, value = "buscaBairro") String buscaBairro,
			@RequestParam(required = false, value = "buscaData") @DateTimeFormat(iso = ISO.DATE) LocalDate buscaData,
			@RequestParam(required = false, value = "buscaDataFinal") @DateTimeFormat(iso = ISO.DATE) LocalDate buscaDataFinal,
			@RequestParam(required = false, value = "status") String status,
			@RequestParam(required = false, value = "resultado") String resultado,
			@RequestParam(required = false, value = "aviso") String aviso, 
			@RequestParam(required = false, value = "indicada") String indicada, ModelMap model) {
	
		return ResponseEntity.ok(service.buscarTodos(request, buscaAssunto, buscaCliente, buscaUsuario, buscaBairro,
				buscaData, buscaDataFinal, status, resultado, aviso, indicada));
	}
	
	@GetMapping("/pdf/personalizado")
	public void relatoriosDeSolicitacoesPersonalizadas(@RequestParam("carregaGroup") String code,
			@RequestParam(required = false, value = "relatorioCliente") String cliente,
			@RequestParam(required = false, value = "relatorioAssunto") String assunto,
			@RequestParam(required = false, value = "relatorioBairro") String bairro,
			@RequestParam(required = false, value = "relatorioUsuario") String usuario,
			@RequestParam(required = false, value = "relatorioDataInicial") @DateTimeFormat(iso = ISO.DATE) LocalDate dataInicial,
			@RequestParam(required = false, value = "relatorioDataFinal") @DateTimeFormat(iso = ISO.DATE) LocalDate dataFinal,
			@RequestParam(required = false, value = "relatorioStatus") String status,
			@RequestParam(required = false, value = "relatorioResultado") String resultado,
			@RequestParam(required = false, value = "relatorioAviso") Boolean aviso,
			@RequestParam(required = false, value = "relatorioIndicada") Boolean indicada, HttpServletResponse response)
			throws IOException, SQLException {
		

		jasperService.addParams("STATUS_DESC", status == null ? null : status);
		jasperService.addParams("MUNICIPE_NOME", cliente.isEmpty() ? null : cliente);
		jasperService.addParams("BAIRRO_DESC", bairro.isEmpty() ? null : bairro);
		jasperService.addParams("ASSUNTO_DESC", assunto.isEmpty() ? null : assunto);
		jasperService.addParams("USUARIO_NOME", usuario.isEmpty() ? null : usuario);
		jasperService.addParams("DATA_INICIAL", dataInicial == null ? null : Date.valueOf(dataInicial));
		jasperService.addParams("DATA_FINAL", dataFinal == null ? null : Date.valueOf(dataFinal));
		jasperService.addParams("RESULTADO", resultado == null ? null : resultado);
		jasperService.addParams("AVISO", aviso == null ? null : aviso);
		jasperService.addParams("INDICADO", indicada == null ? null : indicada);

		byte[] bytes = jasperService.exportarPDF(code);
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		response.setHeader("Content-disposition", "inline; filename=relatorio-" + code + ".pdf");
		response.getOutputStream().write(bytes);
	}
	
	@GetMapping("/pdf/codigo/{id}")
	public void exibirRelatorio09(@PathVariable("id") Long id, @RequestParam("code") String code,
			@RequestParam("tipo") String tipo, HttpServletResponse response) throws IOException, SQLException {

		if (tipo.equals("solicitacao")) {
			Solicitacao solicitacao = service.buscarPorId(id);
			jasperService.addParams("SOLICITACAO_ID", solicitacao.getId());
		}

		byte[] bytes = jasperService.exportarPDF(code);
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		response.setHeader("Content-disposition", "inline; filename=relatorio-" + code + ".pdf");
		response.getOutputStream().write(bytes);
	}
}
