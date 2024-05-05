package com.fatec.LBEGerenciadorDeProjetoSimples.persistence;

import java.util.List;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projeto;

public interface ICrudProjeto {
	public Projeto consultar(Projeto projeto);
	public List<Projeto> listar();
}
