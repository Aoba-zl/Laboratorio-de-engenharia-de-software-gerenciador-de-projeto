package com.fatec.LBEGerenciadorDeProjetoSimples.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
public class Projeto {
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private String descricao;
	private List<Atividade> atividades = new ArrayList<>();
	private List<Equipe> equipe;
}
