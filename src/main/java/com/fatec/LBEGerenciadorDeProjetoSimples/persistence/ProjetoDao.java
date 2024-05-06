package com.fatec.LBEGerenciadorDeProjetoSimples.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projeto;
@Repository
public class ProjetoDao implements ICrudProjeto, ICrudIudProjeto{
	private GenericDao gDao;
	public ProjetoDao (GenericDao gDao) {
		this.gDao = gDao;
	}
	@Override
	public String crudIud(String acao, Projeto projeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Projeto consultar(Projeto projeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Projeto> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
