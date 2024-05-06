package com.fatec.LBEGerenciadorDeProjetoSimples.model;


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
public class Equipe {
	private Projetista projetista;
	private Projeto projeto;
}
