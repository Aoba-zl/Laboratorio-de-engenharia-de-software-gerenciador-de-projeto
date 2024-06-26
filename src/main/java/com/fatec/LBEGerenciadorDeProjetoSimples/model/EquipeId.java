package com.fatec.LBEGerenciadorDeProjetoSimples.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EquipeId implements Serializable{

	private static final long serialVersionUID = 1L;
	private Projetista projetista;
	private Projeto projeto;
}
