package com.fatec.LBEGerenciadorDeProjetoSimples.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projetista;

public interface IProjetistaRepository extends JpaRepository<Projetista, Integer>{
	@Procedure(name = "Projetista.sp_upt_projetista")
	void sp_upt_projetista(@Param("id") int id, @Param("email") String email,@Param("nome") String nome,@Param("usuario") String usuario ,@Param("senha") String senha);
	
	@Procedure(name = "Projetista.sp_del_projetista")
	void sp_del_projetista(@Param("id") int id);
}
