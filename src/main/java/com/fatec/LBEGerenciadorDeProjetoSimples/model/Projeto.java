package com.fatec.LBEGerenciadorDeProjetoSimples.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "dataInicial", nullable = false)
	private LocalDate dataInicial;
	
	@Column(name = "dataFinal", nullable = false)
	private LocalDate dataFinal;
	
	@Column(name = "descricao", length = 100,nullable = false)
	private String descricao;
	
    @OneToMany(mappedBy = "projeto",cascade = CascadeType.ALL)
    private List<Atividade> atividades;
    
    @OneToMany(mappedBy = "projeto", targetEntity = Equipe.class)
    private List<Equipe> equipe;
}
