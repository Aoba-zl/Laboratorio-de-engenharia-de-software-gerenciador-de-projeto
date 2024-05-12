package com.fatec.LBEGerenciadorDeProjetoSimples;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.LBEGerenciadorDeProjetoSimples.controller.ProjetistaController;
import com.fatec.LBEGerenciadorDeProjetoSimples.controller.ProjetoController;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Atividade;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Equipe;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Login;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projetista;
import com.fatec.LBEGerenciadorDeProjetoSimples.model.Projeto;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IAtividadeRepository;
import com.fatec.LBEGerenciadorDeProjetoSimples.repository.IEquipeRepository;

@SpringBootTest
class LbeGerenciadorDeProjetoSimplesApplicationTests {
	
	@Autowired
	private ProjetoController pCon;
	
	@Autowired 
	private ProjetistaController projetistaCon;
	
	@Autowired
	private IEquipeRepository equipeRep;
	
	@Autowired
	private IAtividadeRepository atividadeRep;
	
	@Test
	void contextLoads() {
		
		Projetista pro = new Projetista("a","a");
		Login l = new Login("lulala","aranha",pro);
		pro.setLogin(l);

		Projeto p = new Projeto("lacração",LocalDate.now(), LocalDate.now(),"a");
		Atividade a = new Atividade(p,LocalDate.now(),LocalDate.now(),"a","nome");
		
		Equipe e = new Equipe(pro, p);
		
		pCon.cadastrar("c",p);
		projetistaCon.cadastrar("c", pro);
		atividadeRep.save(a);
		equipeRep.save(e);
		
		List<Projeto> projetos = pCon.listar();
	}

}
