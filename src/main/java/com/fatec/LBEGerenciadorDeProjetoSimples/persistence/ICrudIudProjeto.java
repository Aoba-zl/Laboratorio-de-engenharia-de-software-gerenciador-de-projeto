package com.fatec.LBEGerenciadorDeProjetoSimples.persistence;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projeto;

public interface ICrudIudProjeto {
	public String crudIud(String acao, Projeto projeto);
}
