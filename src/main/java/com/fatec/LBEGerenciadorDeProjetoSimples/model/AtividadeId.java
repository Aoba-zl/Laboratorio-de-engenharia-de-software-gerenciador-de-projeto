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
public class AtividadeId implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private Projeto projeto;
}
