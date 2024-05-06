package com.fatec.LBEGerenciadorDeProjetoSimples.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Atividade;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projeto;
@Repository
public class AtividadeDao implements ICrudAtividade, ICrudIudAtividade {
	private GenericDao gDao;
	public AtividadeDao (GenericDao gDao) {
		this.gDao = gDao;
	}
	@Override
	public String crudIud(String acao, Projeto projeto, Atividade atividade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Atividade consultar(Atividade atividade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Atividade> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
