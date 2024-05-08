package com.fatec.LBEGerenciadorDeProjetoSimples.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Atividade;

public interface IAtividadeRepository extends JpaRepository<Atividade, Integer>{

}
