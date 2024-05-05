package com.fatec.LBEGerenciadorDeProjetoSimples.persistence;

import java.util.List;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Atividade;

public interface ICrudAtividade {
	public Atividade consultar(Atividade atividade);
	public List<Atividade> listar();
}
