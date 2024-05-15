package com.fatec.LBEGerenciadorDeProjetoSimples.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Atividade;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.AtividadeId;

public interface IAtividadeRepository extends JpaRepository<Atividade, AtividadeId>{
	int fn_count_id_atividade(int idProjeto);
}
