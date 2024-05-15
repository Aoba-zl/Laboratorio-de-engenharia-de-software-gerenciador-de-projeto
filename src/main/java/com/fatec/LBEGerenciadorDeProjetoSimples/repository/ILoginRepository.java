package com.fatec.LBEGerenciadorDeProjetoSimples.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Login;

public interface ILoginRepository extends JpaRepository<Login, Integer>{
	@Query(value = "SELECT * FROM fn_login(?1)", nativeQuery = true)
	Login fn_login(String usuario);
}
