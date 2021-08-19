package com.br.FiltrosAndJasper.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "solicitacoes")
public class Solicitacao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="data")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate data;

	private String usuario;

	private String assunto;
	
	private String bairro;
	
	private String municipe;
	
	@Enumerated(EnumType.STRING)
	private SolicitacaoStatus status;
	
	@Column(name = "indicado", columnDefinition = "TINYINT(1)")
	private boolean indicado;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "solucao_id_fk", referencedColumnName = "id", nullable = true)
	private Solucao solucao;
	
	@Lob
	private String descricao;

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipe() {
		return municipe;
	}

	public void setMunicipe(String municipe) {
		this.municipe = municipe;
	}

	public SolicitacaoStatus getStatus() {
		return status;
	}

	public void setStatus(SolicitacaoStatus status) {
		this.status = status;
	}

	public boolean isIndicado() {
		return indicado;
	}

	public void setIndicado(boolean indicado) {
		this.indicado = indicado;
	}

	public Solucao getSolucao() {
		return solucao;
	}

	public void setSolucao(Solucao solucao) {
		this.solucao = solucao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
