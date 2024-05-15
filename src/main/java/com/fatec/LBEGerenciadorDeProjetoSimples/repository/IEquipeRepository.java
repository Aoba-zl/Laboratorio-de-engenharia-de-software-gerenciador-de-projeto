package com.fatec.LBEGerenciadorDeProjetoSimples.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Equipe;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.EquipeId;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projeto;

public interface IEquipeRepository extends JpaRepository<Equipe, EquipeId>{
	List<Equipe> findByProjeto(Projeto projeto);
}
