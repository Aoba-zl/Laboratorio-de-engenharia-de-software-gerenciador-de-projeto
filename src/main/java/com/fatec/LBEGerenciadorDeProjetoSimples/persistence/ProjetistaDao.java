package com.fatec.LBEGerenciadorDeProjetoSimples.persistence;

import org.springframework.stereotype.Repository;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projetista;
@Repository
public class ProjetistaDao implements ICrudIudProjetista, ICrudProjetista {
	private GenericDao gDao;
	public ProjetistaDao (GenericDao gDao) {
		this.gDao = gDao;
	}
	@Override
	public Projetista consultar(Projetista projetista) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String crudIud(String acao, Projetista projetista) {
		// TODO Auto-generated method stub
		return null;
	}

}
