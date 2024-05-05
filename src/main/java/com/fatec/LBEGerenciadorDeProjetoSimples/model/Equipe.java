package com.fatec.LBEGerenciadorDeProjetoSimples.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipe {
	private Projetista projetista;
	private Projeto projeto;
}
