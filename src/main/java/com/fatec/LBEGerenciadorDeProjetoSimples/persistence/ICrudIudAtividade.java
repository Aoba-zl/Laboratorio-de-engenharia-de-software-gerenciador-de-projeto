package com.fatec.LBEGerenciadorDeProjetoSimples.persistence;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Atividade;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projeto;

public interface ICrudIudAtividade {
	public String crudIud(String acao,Projeto projeto,Atividade atividade);
}
