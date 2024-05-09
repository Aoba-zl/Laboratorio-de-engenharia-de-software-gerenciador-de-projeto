package com.fatec.LBEGerenciadorDeProjetoSimples.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.GeneratorType;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "projeto")
public class Projeto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "dataInicial", nullable = false)
	private LocalDate dataInicial;
	
	@Column(name = "dataFinal", nullable = false)
	private LocalDate dataFinal;
	
	@Column(name = "descricao", length = 100,nullable = false)
	private String descricao;
	
	@OneToMany(mappedBy = "projeto")
	private Set<Atividade> atividades;
	
	@OneToMany(mappedBy = "projeto")
	private Set<Equipe> equipe;
	
	public Projeto(String nome,LocalDate dataInicial, LocalDate dataFinal, String descricao) {
		super();
		this.nome = nome;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.descricao = descricao;
	}
}
