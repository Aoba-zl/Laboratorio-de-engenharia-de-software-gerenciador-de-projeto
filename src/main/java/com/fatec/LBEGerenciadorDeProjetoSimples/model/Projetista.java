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
public class Projetista {
	private String email;
	private String nome;
	private int id;
	private Equipe equipe;
	private Login login;
}
