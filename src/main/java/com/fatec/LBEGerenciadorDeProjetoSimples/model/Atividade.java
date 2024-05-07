package com.fatec.LBEGerenciadorDeProjetoSimples.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Atividade {
	@Column(name = "dataInicial", nullable = false)
	private LocalDate dataInicial;
	
	@Column(name = "dataFinal", nullable = false)
	private LocalDate dataFinal;
	
	@Column(name = "descricao", length = 100,nullable = false)
	private String descricao;
	
	@Column(name = "nome", length = 50,nullable = false)
	private String nome;
	
    @ManyToOne
    @JoinColumn(name = "projetoid",nullable = false)
    private Projeto projeto;
}
