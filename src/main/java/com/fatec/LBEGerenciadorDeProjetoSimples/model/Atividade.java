package com.fatec.LBEGerenciadorDeProjetoSimples.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "atividade")
@IdClass(AtividadeId.class)
public class Atividade {
	@Column(name = "dataInicial", nullable = false)
	private LocalDate dataInicial;
	
	@Column(name = "dataFinal", nullable = false)
	private LocalDate dataFinal;
	
	@Column(name = "descricao", length = 100,nullable = false)
	private String descricao;
	

	@Id
	@Column(name = "nome", length = 50,nullable = false)
	private String nome;
	
	@Id
    @ManyToOne(targetEntity = Projeto.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "projetoid",nullable = false)
    private Projeto projeto;
	
	public Atividade(LocalDate dataInicial, LocalDate dataFinal, String descricao, String nome) {
		super();
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.descricao = descricao;
		this.nome = nome;
	}
}
