package com.fatec.LBEGerenciadorDeProjetoSimples;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.LBEGerenciadorDeProjetoSimples.controller.ProjetistaController;
import com.fatec.LBEGerenciadorDeProjetoSimples.controller.ProjetoController;

@SpringBootTest
class LbeGerenciadorDeProjetoSimplesApplicationTests {
	
	@Autowired
	private ProjetoController pCon;
	
	@Autowired 
	private ProjetistaController projetistaCon;
	
	@Test
	void contextLoads() {
//		pCon.opProjeto();
//		projetistaCon.opProjetista();
	}

}
