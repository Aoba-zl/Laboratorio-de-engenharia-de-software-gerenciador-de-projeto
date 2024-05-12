package com.fatec.LBEGerenciadorDeProjetoSimples.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projeto;

public interface IProjetoRepository extends JpaRepository<Projeto, Integer>{
	@Procedure(name = "Projeto.sp_del_projeto")
	void sp_del_projeto(@Param("id") int id);
}
