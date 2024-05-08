package com.fatec.LBEGerenciadorDeProjetoSimples.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projeto;

public interface IProjetoRepository extends JpaRepository<Projeto, Integer>{

}
