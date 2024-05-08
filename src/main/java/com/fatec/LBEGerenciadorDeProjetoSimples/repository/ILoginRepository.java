package com.fatec.LBEGerenciadorDeProjetoSimples.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Login;

public interface ILoginRepository extends JpaRepository<Login, Integer>{

}
