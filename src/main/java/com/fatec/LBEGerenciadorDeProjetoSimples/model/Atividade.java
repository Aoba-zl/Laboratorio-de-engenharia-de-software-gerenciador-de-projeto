package com.fatec.LBEGerenciadorDeProjetoSimples.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
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
@NamedNativeQuery(
		name = "Atividade.fn_count_id_atividade",
		query = "SELECT dbo.fn_count_id_atividade(?1)",
		resultClass = Integer.class
)
public class Atividade {
	@Id
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "nome", length = 50,nullable = false)
	private String nome;
	
	@Column(name = "descricao", length = 100,nullable = false)
	private String descricao;
	
	@Column(name = "dataInicial", nullable = false)
	private LocalDate dataInicial;
	
	@Column(name = "dataFinal", nullable = false)
	private LocalDate dataFinal;
	
	@Id
    @ManyToOne(targetEntity = Projeto.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "projetoId",nullable = false) 
    private Projeto projeto;

	public Atividade(String nome, String descricao, LocalDate dataInicial, LocalDate dataFinal, Projeto projeto) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.projeto = projeto;
	}
}
