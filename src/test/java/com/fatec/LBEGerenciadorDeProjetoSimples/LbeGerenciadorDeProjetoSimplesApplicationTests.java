package com.fatec.LBEGerenciadorDeProjetoSimples;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.LBEGerenciadorDeProjetoSimples.controller.ProjetistaController;

@SpringBootTest
class LbeGerenciadorDeProjetoSimplesApplicationTests {
	
	@Autowired
	private ProjetistaController pCon;

	@Test
	void contextLoads() {
		//pCon.opProjetista();
	}

}
